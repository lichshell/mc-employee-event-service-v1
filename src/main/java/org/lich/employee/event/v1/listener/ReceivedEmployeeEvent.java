package org.lich.employee.event.v1.listener;

import org.lich.employee.event.v1.model.Employee;

public record ReceivedEmployeeEvent(String key, int partition, long offset, Employee value) { }
