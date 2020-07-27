package com.dev.wellness.models.outbounds;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class PageDataResponse<T> extends BaseResponse {
  private List<T> data;

  private Paging paging;

  @Builder(builderMethodName = "dataBuilder")
  private PageDataResponse(int code, String status, List<T> data, Paging paging) {

    super(code, status);
    this.data = data;
    this.paging = paging;
  }
}
