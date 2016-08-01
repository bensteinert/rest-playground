package net.bensteinert;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author bensteinert
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);
}
