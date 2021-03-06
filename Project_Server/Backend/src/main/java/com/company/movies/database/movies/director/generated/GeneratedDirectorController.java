package com.company.movies.database.movies.director.generated;

import com.company.movies.MoviesApplication;
import com.company.movies.database.movies.director.Director;
import com.company.movies.database.movies.director.DirectorManager;
import com.speedment.common.annotation.GeneratedCode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * The default REST controller logic
 * <p>
 * This file has been automatically generated by Speedment. Any changes made to
 * it will be overwritten.
 * 
 * @author Speedment
 */
@GeneratedCode("Speedment")
public abstract class GeneratedDirectorController {
    
    protected @Autowired MoviesApplication app;
    protected @Autowired DirectorManager manager;
    
    @RequestMapping(value = "/director", method = GET)
    public List<Director> get(@RequestParam(value = "start", defaultValue = "0") long start,
            @RequestParam(value = "limit", defaultValue = "25") long limit) {
        return manager.stream()
            .skip(start)
            .limit(limit)
            .collect(toList());
    }
}