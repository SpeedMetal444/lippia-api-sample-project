package api.model.timeentry; 
import java.util.ArrayList;
public class Root{
    public String id;
    public String description;
    public ArrayList<Object> tagIds;
    public String userId;
    public boolean billable;
    public Object taskId;
    public String projectId;
    public String workspaceId;
    public TimeInterval timeInterval;
    public ArrayList<Object> customFieldValues;
    public String type;
    public Object kioskId;
    public HourlyRate hourlyRate;
    public CostRate costRate;
    public boolean isLocked;
}
