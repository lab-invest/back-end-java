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

    @Query("{'uuid':  ?0 }")
    Optional<User> findByUuid(String uuid);

    void deleteByUuid(String uuid);

    @Query("{ 'email': ?0 }")
    @Update("{ $set: { 'wallets.?1.?2': ?3 } }")
    void addStockToWallet(String email, String walletName, String ticker, Stock stock);
    @Query("{ 'email': ?0 }")
    @Update("{ $set: { 'wallets.?1.?2.quantity': ?3, 'wallets.?1.?2.averagePrice': ?4 } }")
    void updateStockQuantityAndAveragePrice(String email, String walletName, String ticker, int quantity, double averagePrice);

    @Query("{'email':  ?0 }")
    @Update("{$inc: {'quantity': -?1}}")
    void updateQuantity(String email, double totalPrice);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'balance': ?1 } }")
    void updateBalance(String uuid, double amount);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'balance': 10000 } }")
    void resetBalance(String uuid);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'wallets': { 'geral': {} }  }}")
    void resetWallet(String uuid);

    @Query("{ 'email': ?0 }")
    @Update("{ $unset: { 'wallets.?1.?2': '' } }")
    void deleteStockFromWallet(String email, String walletName, String ticker);

    @Query("{ 'email': ?0 }")
    @Update("{ $unset: { 'wallets.geral.?1': '' } }")
    void deleteStockFromGeral(String email, String ticker);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'name': ?1 } }")
    void updateName(String uuid, String ticker);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'userPhoto': ?1 } }")
    void updateUrl(String uuid,String ticker);

    @Query("{ 'uuid': ?0 }")
    @Update("{ $set: { 'rentability': ?1 } }")
    void updateRentability(String uuid, double rentability);

}
