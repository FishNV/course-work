package org.example.automation.api.task;

import com.google.gson.JsonObject;
import org.example.automation.api.JSONRPCClass;

import java.util.HashMap;
import java.util.Map;

public class TaskCreation {

    public JsonObject createTask(String title,
                                 Integer projectId,
                                 String colorId,
                                 Integer columnId,
                                 Integer ownerId,
                                 Integer creatorId,
                                 String dateDue,
                                 String description,
                                 Integer categoryId,
                                 Integer score,
                                 Integer swimlaneId,
                                 Integer priority,
                                 Integer recurrenceStatus,
                                 Integer recurrenceTrigger,
                                 Integer recurrenceFactor,
                                 Integer recurrenceTimeframe,
                                 Integer recurrenceBasedate,
                                 String reference) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("project_id", projectId);
        if (colorId != null)
            params.put("color_id", colorId);
        if (columnId != null)
            params.put("column_id", columnId);
        if (ownerId != null)
            params.put("owner_id", ownerId);
        if (creatorId != null)
            params.put("creator_id", creatorId);
        if (dateDue != null)
            params.put("date_due", dateDue);
        if (description != null)
            params.put("description", description);
        if (categoryId != null)
            params.put("category_id", categoryId);
        if (score != null)
            params.put("score", score);
        if (swimlaneId != null)
            params.put("swimlane_id", swimlaneId);
        if (priority != null)
            params.put("priority", priority);
        if (recurrenceStatus != null)
            params.put("recurrence_status", recurrenceStatus);
        if (recurrenceTrigger != null)
            params.put("recurrence_trigger", recurrenceTrigger);
        if (recurrenceFactor != null)
            params.put("recurrence_factor", recurrenceFactor);
        if (recurrenceTimeframe != null)
            params.put("recurrence_timeframe", recurrenceTimeframe);
        if (recurrenceBasedate != null)
            params.put("recurrence_basedate", recurrenceBasedate);
        if (reference != null)
            params.put("reference", reference);
        return JSONRPCClass.baseRequest("createTask", params);
    }

    public JsonObject createTask(String title, Integer projectId) {
        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("project_id", projectId);
        return JSONRPCClass.baseRequest("createTask", params);
    }
}
