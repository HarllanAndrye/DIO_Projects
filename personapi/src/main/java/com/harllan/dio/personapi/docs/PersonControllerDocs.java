package com.harllan.dio.personapi.docs;

import java.util.List;

import com.harllan.dio.personapi.config.SwaggerConfig;
import com.harllan.dio.personapi.dto.request.PersonDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Pessoas", tags = { SwaggerConfig.TAG_PERSON })
public interface PersonControllerDocs {
	
	@ApiOperation(value = "Retorna uma lista de pessoas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de pessoas."),
    })
	public List<PersonDTO> listAll();

}
