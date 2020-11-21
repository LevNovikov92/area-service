package com.lev.areaservice.area.search;

import com.lev.areaservice.area.search.filter.SearchFilter;
import com.lev.areaservice.area.search.vo.AreaData;
import com.lev.areaservice.area.search.vo.AreaFromFilter;
import com.lev.areaservice.area.search.vo.SafetyData;
import com.lev.areaservice.landmark.Landmark;
import com.lev.areaservice.school.School;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.*;

@AllArgsConstructor
public class SearchAreaRepoImpl implements SearchAreaRepo {

    private final JdbcTemplate template;

    @Override
    public AreaData getAreaData(int id) {
        return template.queryForObject(queryAreaData, (rs, rowNum) ->
                new AreaData(
                        rs.getInt(1),
                        rs.getString(2),
                        new SafetyData(
                                rs.getFloat(4),
                                rs.getFloat(5)
                        )), id);
    }

    private static final String queryAreaData = "SELECT * FROM `area` as a " +
            "LEFT JOIN `area_safety` as `as` on a.id = `as`.area_id WHERE a.id = ?";

    @Override
    public List<AreaFromFilter> getByFilter(SearchFilter filter) {
        var query = "SELECT a.id, a.title, `as`.score_avg, l.id, l.title, l.desc, s.title " +
                "FROM `area` as a" +
                "         left join school s on a.id = s.area" +
                "         left join landmark l on a.id = l.area_id" +
                "         left join area_safety `as` on a.id = `as`.area_id " +
                "WHERE 1";

        final List<Object> args = new ArrayList<>();
        if (filter.getSchoolType() != null) {
            query += " AND s.type_id = ?";
            args.add(filter.getSchoolType());
        }

        if (filter.getMinSafety() != null) {
            query += " AND `as`.score_avg > ?";
            args.add(filter.getMinSafety());
        }

        if (filter.getLandmarkKey() != null) {
            query += " AND l.title LIKE ?";
            args.add("%" + filter.getLandmarkKey() + "%");
        }

        Map<Integer, AreaFromFilter> map = new HashMap<>();
        template.query(query, (RowMapper<Object>) (rs, rowNum) -> {
            var id = rs.getInt(1);
            var title = rs.getString(2);
            var score = rs.getFloat(3);
            var landmarkId = rs.getInt(4);
            var landmarkTitle = rs.getString(5);
            var landmarkDesc = rs.getString(6);
            var schoolTitle = rs.getString(7);

            var data = map.getOrDefault(id, new AreaFromFilter(id, title, score, new HashSet<>(), new HashSet<>()));
            data.getLandmarks().add(new Landmark(landmarkId, landmarkTitle, landmarkDesc, id));
            data.getSchools().add(new School(schoolTitle));
            map.put(id, data);
            return rs;
        }, args.toArray());
        return new ArrayList<>(map.values());
    }
}
