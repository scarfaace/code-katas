package org.example.resp.datatypes;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RespDataType {

  Object value;
  String dataType;

}
