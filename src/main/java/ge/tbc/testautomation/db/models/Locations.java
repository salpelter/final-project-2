package ge.tbc.testautomation.db.models;

import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true, fluent = true)
public class Locations {
    public String area;
    public int minResultCount;
}
