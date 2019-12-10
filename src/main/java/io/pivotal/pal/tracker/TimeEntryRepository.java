package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(long timeEntryId);
    TimeEntry update(long id, TimeEntry entry);
    List<TimeEntry> list();
    void delete(long id);
}
