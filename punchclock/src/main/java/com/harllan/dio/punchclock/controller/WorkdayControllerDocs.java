package com.harllan.dio.punchclock.controller;

import java.util.List;

import com.harllan.dio.punchclock.config.SwaggerConfig;
import com.harllan.dio.punchclock.entity.Workday;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Jornada de trabalho", tags = { SwaggerConfig.TAG_WORKDAY })
public interface WorkdayControllerDocs {
	
	@ApiOperation(value = "Retorna uma lista de jornadas de trabalho.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de jornadas de trabalho."),
    })
	public List<Workday> getWorkdayList();

}
