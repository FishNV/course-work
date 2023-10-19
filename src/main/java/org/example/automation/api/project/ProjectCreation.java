package org.example.automation.api.project;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;
import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ProjectCreation {

    public JsonObject createProject(String name,
                                    String description,
                                    Integer ownerId,
                                    String identifier,
                                    String startDate,
                                    String endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        if (description != null)
            params.put("description", description);
        if (ownerId != null)
            params.put("owner_id", ownerId);
        if (identifier != null)
            params.put("identifier", identifier);
        if (startDate != null)
            params.put("start_date", startDate);
        if (endDate != null)
            params.put("end_date", endDate);
        return JSONRPCClass.baseRequest("createProject", params);
    }
}
