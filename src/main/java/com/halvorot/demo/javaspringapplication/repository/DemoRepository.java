package com.halvorot.demo.javaspringapplication.repository;

import com.halvorot.demo.javaspringapplication.model.DemoObject;
import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

    public DemoObject findDemoObject() {
        return new DemoObject(1, "Demo name");
    }

}
