package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    Map<Long, TimeEntry> data;
    int lastId;

    public InMemoryTimeEntryRepository() {
        this.data = new HashMap<Long,TimeEntry>();
        lastId = 1;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(lastId);
        lastId++;
        data.put(timeEntry.getId(), timeEntry);

        return timeEntry;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return data.get(timeEntryId);
    }

    @Override
    public TimeEntry update(long id, TimeEntry entry) {
        if (data.containsKey(id)) {
            entry.setId(id);
            data.put(id, entry);
            return entry;
        } else {
            return null;
        }

    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(data.values());
    }

    @Override
    public void delete(long id) {
        data.remove(id);
    }
}
