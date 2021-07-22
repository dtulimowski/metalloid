package io.metalloid.api;

import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface PlaceHolderClient {
    @RequestLine("GET /{index}")
    Photos getByIndex(@Param("index") int index);

    @RequestLine("GET/")
    List<Photos> getAll();
}
