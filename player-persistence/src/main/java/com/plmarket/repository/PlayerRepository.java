package com.plmarket.repository;

import com.plmarket.domain.Player;
import com.plmarket.domain.Team;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Player repository.
 *
 * @author SShankunas
 */
@Repository
public interface PlayerRepository extends BaseRepository<Player> {

    @Modifying
    @Query("UPDATE Player SET team = ?2, contractDate = current_date WHERE id = ?1")
    void transfer(UUID id, Team team);

    @Modifying
    @Query("UPDATE Player SET team = null, contractDate = null WHERE id = ?1")
    void remove(UUID id);

}
