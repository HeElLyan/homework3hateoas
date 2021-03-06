package ru.he.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.he.services.BandService;

@RepositoryRestController
public class BandController {

    @Autowired
    private BandService bandService;

    @RequestMapping(value = "/bands/{band-id}/publish", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> publish(@PathVariable("band-id") Long bandId) {
        return ResponseEntity.ok(
                EntityModel.of(bandService.publish(bandId)));
    }
}
