package com.Marvellous.MarvellousPortal.Controller;

import com.Marvellous.MarvellousPortal.Entity.BatchEntry;
import com.Marvellous.MarvellousPortal.Service.BatchEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batches")
public class BatchEntryController {

    @Autowired
    private BatchEntryService batchEntryService;

    // 1️⃣ POST - Add a new batch
    @PostMapping("/add")
    public String addBatch(@RequestBody BatchEntry batch) {
        batchEntryService.saveEntry(batch);
        return "✅ Document Inserted Successfully!";
    }

    // 2️⃣ GET - Retrieve all batches
    @GetMapping("/all")
    public List<BatchEntry> getAllBatches() {
        return batchEntryService.getAllEntries();
    }

    // 3️⃣ GET - Retrieve batch by ID
    @GetMapping("/{id}")
    public Optional<BatchEntry> getBatchById(@PathVariable String id) {
        return batchEntryService.getEntryById(id);
    }

    // 4️⃣ PUT - Update batch by ID
    @PutMapping("/update/{id}")
    public String updateBatch(@PathVariable String id, @RequestBody BatchEntry updatedBatch) {
        return batchEntryService.updateEntry(id, updatedBatch);
    }

    // 5️⃣ DELETE - Delete batch by ID
    @DeleteMapping("/delete/{id}")
    public String deleteBatch(@PathVariable String id) {
        batchEntryService.deleteEntry(id);
        return "🗑️ Document with ID " + id + " deleted successfully!";
    }
}
