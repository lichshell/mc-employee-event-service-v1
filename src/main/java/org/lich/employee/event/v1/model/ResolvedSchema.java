package org.lich.employee.event.v1.model;

import io.confluent.kafka.schemaregistry.json.JsonSchema;

/** A schema version fetched from the registry. */
public record ResolvedSchema(JsonSchema schema, int version, int id) { }
