package ge.tbc.testautomation.db.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LocationsMapper {
    @Select("SELECT expected_min_results FROM locations WHERE area = #{areaName}")
    int getMinResultCountByArea(String areaName);
}
