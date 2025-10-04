package com.Marvellous.MarvellousPortal.Repository;

import com.Marvellous.MarvellousPortal.Entity.BatchEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatchEntryRepository extends MongoRepository<BatchEntry, String>
{
    //  The second type parameter is String (not ObjectId)
}
