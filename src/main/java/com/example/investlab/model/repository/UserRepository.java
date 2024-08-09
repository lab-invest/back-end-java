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
    @Query("{ 'email': ?0, 'wallets': { '$elemMatch': { 'name': ?1, 'stockList': { '$elemMatch': { 'ticker': ?2 } } } } }")
    Optional<User> countByWalletNameAndStockTicker(String email, String walletName, String ticker);

    @Query("{ 'email': ?0, 'wallets.name': ?1 }")
    @Update("{ $push: { 'wallets.$.stockList': ?2 } }")
    void addStockToWallet(String email, String walletName, Stock stock);

    @Query("{ 'email': ?0, 'wallets': { '$elemMatch': { 'name': ?1, 'stockList': { '$elemMatch': { 'ticker': ?3 } } } } }")
    void updateStockQuantityAndAveragePrice(String email, String walletName, Stock stock, String ticker);
}
