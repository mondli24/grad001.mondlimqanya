package com.enviro.assessment.grad001.mondlimqanya;

import com.enviro.assessment.grad001.mondlimqanya.model.WasteCategory;
import com.enviro.assessment.grad001.mondlimqanya.service.WasteCategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.*;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.when;

public class WasteCategoryServiceTest {

    @Mock
    private WasteCategoryService wasteCategoryService;

    @InjectMocks
    private WasteCategoryServiceTest wasteCategoryServiceTest;

    private WasteCategory wasteCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        wasteCategory = new WasteCategory(1L, "Plastic", "Non-biodegradable", true);
    }

    @Test
    void testSaveWasteCategory() {
        when(wasteCategoryService.saveWasteCategory(wasteCategory)).thenReturn(wasteCategory);
        WasteCategory savedCategory = wasteCategoryService.saveWasteCategory(wasteCategory);
        assertNotNull(savedCategory);
        assertEquals("Plastic", savedCategory.getName());
    }

    @Test
    void testGetAllWasteCategories() {
        List<WasteCategory> categories = Arrays.asList(wasteCategory);
        when(wasteCategoryService.getAllWasteCategories()).thenReturn(categories);

        List<WasteCategory> retrievedCategories = wasteCategoryService.getAllWasteCategories();
        assertNotNull(retrievedCategories);
        assertEquals(1, retrievedCategories.size());
    }

    @Test
    void testGetWasteCategoryById() {
        when(wasteCategoryService.getWasteCategoryById(1L)).thenReturn(Optional.of(wasteCategory));

        Optional<WasteCategory> retrievedCategory = wasteCategoryService.getWasteCategoryById(1L);
        assertTrue(retrievedCategory.isPresent());
        assertEquals("Plastic", retrievedCategory.get().getName());
    }

    @Test
    void testUpdateWasteCategory() {
        WasteCategory updatedCategory = new WasteCategory(1L, "Updated Name", "Updated Description", false);
        when(wasteCategoryService.updateWasteCategory(1L, updatedCategory)).thenReturn(updatedCategory);

        WasteCategory result = wasteCategoryService.updateWasteCategory(1L, updatedCategory);
        assertNotNull(result);
        assertEquals("Updated Name", result.getName());
    }

    @Test
    void testDeleteWasteCategory() {
        doNothing().when(wasteCategoryService).deleteWasteCategory(1L);

        assertDoesNotThrow(() -> wasteCategoryService.deleteWasteCategory(1L));
        verify(wasteCategoryService, times(1)).deleteWasteCategory(1L);
    }
}
