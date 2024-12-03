package com.sho.MovieApi.controller;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sho.MovieApi.model.Cast;
import com.sho.MovieApi.service.CastService;

@RestController
public class CastController {
    @Autowired
    private CastService castService;

    @GetMapping("/casts")
    public ResponseEntity<Iterable<Cast>> getCastList() {
        return ResponseEntity.ok(castService.getCastList());
    }

    @GetMapping("/casts/{castId}")
    public ResponseEntity<Cast> getCast(@PathVariable Long castId) {
        return ResponseEntity.ok(castService.getCast(castId));
    }

    @PostMapping("/casts")
    public ResponseEntity<Void> createCast(@RequestBody Cast newCast) {
        Cast createdCast = castService.createCast(newCast);
        URI new_cast_location = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path("/{resourceId}")
            .buildAndExpand(createdCast.getId())
            .toUri();
        return ResponseEntity.created(new_cast_location).build();
    }

    @PutMapping("/casts/{castId}")
    public ResponseEntity<Void> updateCast(@PathVariable Long castId, @RequestBody Cast updatedCast) {
        castService.updateCast(castId, updatedCast);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/casts/{castId}")
    public ResponseEntity<Void> deleteCast(@PathVariable Long castId) {
        castService.deleteCast(castId);
        return ResponseEntity.noContent().build();
    }
}
