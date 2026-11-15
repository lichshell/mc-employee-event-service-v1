package org.lich.employee.event.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Superset of all three registered schema versions (v1 -> v2 -> v3).
 * Fields added in later versions are optional and NON_NULL-excluded, because the
 * registered schemas are closed (additionalProperties=false) and reject explicit nulls.
 *
 * v1: employeeId, firstName, lastName, email
 * v2: + department, jobTitle, hireDate
 * v3: + location, skills
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Employee(
        String employeeId,
        String firstName,
        String lastName,
        String email,
        String department,
        String jobTitle,
        String hireDate,
        Location location,
        List<String> skills,
        String unit) {

    public static Builder builder() { return new Builder(); }

    /** usage : employee.toBuilder().department("Risk").build() */
    public Builder toBuilder() {
        return new Builder().employeeId(employeeId).firstName(firstName).lastName(lastName)
                .email(email).department(department).jobTitle(jobTitle)
                .hireDate(hireDate).location(location).skills(skills).unit(unit);
    }

    public static final class Builder {
        private String employeeId, firstName, lastName, email, department, jobTitle, hireDate, unit;
        private Location location;
        private List<String> skills;

        public Builder employeeId(String v) { this.employeeId = v; return this; }
        public Builder firstName(String v)  { this.firstName = v;  return this; }
        public Builder lastName(String v)  { this.lastName = v;  return this; }
        public Builder email(String v)  { this.email = v;  return this; }
        public Builder department(String v)  { this.department = v;  return this; }
        public Builder jobTitle(String v)  { this.jobTitle = v;  return this; }
        public Builder location(Location v)  { this.location = v;  return this; }
        public Builder skills(List<String>  v)  { this.skills = v;  return this; }
        public Builder hireDate(String v)  { this.hireDate = v;  return this; }
        public Builder unit(String v)  { this.unit = v;  return this; }

        public Employee build() {
            return new Employee(employeeId, firstName, lastName, email, department,
                    jobTitle, hireDate, location, skills, unit);
        }
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public record Location(String city, String country) { }
}
