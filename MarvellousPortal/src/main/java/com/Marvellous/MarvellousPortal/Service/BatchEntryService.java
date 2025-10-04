package com.Marvellous.MarvellousPortal.Service;

import com.Marvellous.MarvellousPortal.Entity.BatchEntry;
import com.Marvellous.MarvellousPortal.Repository.BatchEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchEntryService {

    @Autowired
    private BatchEntryRepository batchEntryRepository;

    // 1️⃣ POST - Save a new batch
    public void saveEntry(BatchEntry batch) {
        batchEntryRepository.save(batch);
    }

    // 2️⃣ GET - Retrieve all batches
    public List<BatchEntry> getAllEntries() {
        return batchEntryRepository.findAll();
    }

    // 3️⃣ GET - Retrieve batch by ID
    public Optional<BatchEntry> getEntryById(String id) {
        return batchEntryRepository.findById(id);
    }

    // 4️⃣ PUT - Update existing batch
    public String updateEntry(String id, BatchEntry updatedBatch) {
        Optional<BatchEntry> existingBatch = batchEntryRepository.findById(id);

        if (existingBatch.isPresent()) {
            BatchEntry batch = existingBatch.get();
            batch.setName(updatedBatch.getName());
            batch.setFee(updatedBatch.getFee());
            batchEntryRepository.save(batch);
            return "✅ Batch updated successfully!";
        } else {
            return "❌ Batch with ID " + id + " not found.";
        }
    }

    // 5️⃣ DELETE - Remove a batch
    public void deleteEntry(String id) {
        batchEntryRepository.deleteById(id);
    }
}
