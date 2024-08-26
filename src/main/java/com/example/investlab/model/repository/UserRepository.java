package com.example.investlab.model.repository;


import com.example.investlab.model.entitys.Stock;
import com.example.investlab.model.entitys.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

    void deleteByEmail(String email);

    @Query("{ 'email': ?0, 'wallets.?1.?2': { $exists: true } }")
    Optional<User> countByWalletNameAndStockTicker(String email, String walletName, String ticker);

    @Query("{ 'email': ?0 }")
    @Update("{ $set: { 'wallets.?1.?2': ?3 } }")
    void addStockToWallet(String email, String walletName, String ticker, Stock stock);
    @Query("{ 'email': ?0 }")
    @Update("{ $set: { 'wallets.?1.?2.quantity': ?3, 'wallets.?1.?2.averagePrice': ?4 } }")
    void updateStockQuantityAndAveragePrice(String email, String walletName, String ticker, int quantity, double averagePrice);

    @Query("{'email':  ?0 }")
    @Update("{$inc: {'quantity': -?1}}")
    void updateQuantity(String email, double totalPrice);
}
