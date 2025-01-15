package com.enviro.assessment.grad001.mondlimqanya;

import com.enviro.assessment.grad001.mondlimqanya.model.RecyclingTip;
import com.enviro.assessment.grad001.mondlimqanya.service.RecyclingTipService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RecyclingTipServiceTest {

    @Mock
    private RecyclingTipService recyclingTipService;

    @InjectMocks
    private RecyclingTipServiceTest recyclingTipServiceTest;

    private RecyclingTip recyclingTip;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        recyclingTip = new RecyclingTip(1L, "Reuse plastic bottles", null);
    }

    @Test
    void testSaveRecyclingTip() {
        when(recyclingTipService.saveRecyclingTip(recyclingTip)).thenReturn(recyclingTip);
        RecyclingTip savedTip = recyclingTipService.saveRecyclingTip(recyclingTip);
        assertNotNull(savedTip);
        assertEquals("Reuse plastic bottles", savedTip.getTip());
    }

    @Test
    void testGetAllRecyclingTips() {
        List<RecyclingTip> tips = Arrays.asList(recyclingTip);
        when(recyclingTipService.getAllRecyclingTips()).thenReturn(tips);

        List<RecyclingTip> retrievedTips = recyclingTipService.getAllRecyclingTips();
        assertNotNull(retrievedTips);
        assertEquals(1, retrievedTips.size());
    }

    @Test
    void testGetRecyclingTipById() {
        when(recyclingTipService.getRecyclingTipById(1L)).thenReturn(Optional.of(recyclingTip));

        Optional<RecyclingTip> retrievedTip = recyclingTipService.getRecyclingTipById(1L);
        assertTrue(retrievedTip.isPresent());
        assertEquals("Reuse plastic bottles", retrievedTip.get().getTip());
    }

    @Test
    void testUpdateRecyclingTip() {
        RecyclingTip updatedTip = new RecyclingTip(1L, "Updated Tip", null);
        when(recyclingTipService.updateRecyclingTip(1L, updatedTip)).thenReturn(updatedTip);

        RecyclingTip result = recyclingTipService.updateRecyclingTip(1L, updatedTip);
        assertNotNull(result);
        assertEquals("Updated Tip", result.getTip());
    }

    @Test
    void testDeleteRecyclingTip() {
        doNothing().when(recyclingTipService).deleteRecyclingTip(1L);

        assertDoesNotThrow(() -> recyclingTipService.deleteRecyclingTip(1L));
        verify(recyclingTipService, times(1)).deleteRecyclingTip(1L);
    }
}
