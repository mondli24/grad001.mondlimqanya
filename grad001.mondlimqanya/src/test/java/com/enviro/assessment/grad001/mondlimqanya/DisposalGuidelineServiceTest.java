package com.enviro.assessment.grad001.mondlimqanya;

import com.enviro.assessment.grad001.mondlimqanya.model.DisposalGuideline;
import com.enviro.assessment.grad001.mondlimqanya.service.DisposalGuidelineService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class DisposalGuidelineServiceTest {

    @Mock
    private DisposalGuidelineService disposalGuidelineService;

    @InjectMocks
    private DisposalGuidelineServiceTest disposalGuidelineServiceTest;

    private DisposalGuideline disposalGuideline;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        disposalGuideline = new DisposalGuideline(1L, "Plastic", "Dispose in blue bin", null);
    }

    @Test
    void testSaveDisposalGuideline() {
        when(disposalGuidelineService.saveDisposalGuideline(disposalGuideline)).thenReturn(disposalGuideline);
        DisposalGuideline savedGuideline = disposalGuidelineService.saveDisposalGuideline(disposalGuideline);
        assertNotNull(savedGuideline);
        assertEquals("Plastic", savedGuideline.getMaterial());
    }

    @Test
    void testGetAllDisposalGuidelines() {
        List<DisposalGuideline> guidelines = Arrays.asList(disposalGuideline);
        when(disposalGuidelineService.getAllDisposalGuidelines()).thenReturn(guidelines);

        List<DisposalGuideline> retrievedGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        assertNotNull(retrievedGuidelines);
        assertEquals(1, retrievedGuidelines.size());
    }

    @Test
    void testGetDisposalGuidelineById() {
        when(disposalGuidelineService.getDisposalGuidelineById(1L)).thenReturn(Optional.of(disposalGuideline));

        Optional<DisposalGuideline> retrievedGuideline = disposalGuidelineService.getDisposalGuidelineById(1L);
        assertTrue(retrievedGuideline.isPresent());
        assertEquals("Plastic", retrievedGuideline.get().getMaterial());
    }

    @Test
    void testUpdateDisposalGuideline() {
        DisposalGuideline updatedGuideline = new DisposalGuideline(1L, "Updated Material", "Updated Guideline", null);
        when(disposalGuidelineService.updateDisposalGuideline(1L, updatedGuideline)).thenReturn(updatedGuideline);

        DisposalGuideline result = disposalGuidelineService.updateDisposalGuideline(1L, updatedGuideline);
        assertNotNull(result);
        assertEquals("Updated Material", result.getMaterial());
    }

    @Test
    void testDeleteDisposalGuideline() {
        doNothing().when(disposalGuidelineService).deleteDisposalGuideline(1L);

        assertDoesNotThrow(() -> disposalGuidelineService.deleteDisposalGuideline(1L));
        verify(disposalGuidelineService, times(1)).deleteDisposalGuideline(1L);
    }
}
