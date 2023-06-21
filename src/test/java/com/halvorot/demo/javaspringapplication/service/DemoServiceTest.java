package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.model.DemoObject;
import com.halvorot.demo.javaspringapplication.repository.DemoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DemoServiceTest {
    
    @Mock
    private DemoRepository demoRepository;

    @Test
    void should_get_demo_object() {
        // Arrange
        DemoObject demoObject = new DemoObject(5, "name");
        Mockito.when(demoRepository.findDemoObject()).thenReturn(demoObject);
        DemoService demoService = new DemoService(demoRepository);

        // Act
        DemoObject result = demoService.getDemoObject();

        // Assert
        assertThat(result.id()).isEqualTo(demoObject.id());
        assertThat(result.name()).isEqualTo(demoObject.name());
    }

}