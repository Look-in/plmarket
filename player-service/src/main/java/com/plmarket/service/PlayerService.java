package com.plmarket.service;

import com.plmarket.domain.Player;
import java.util.UUID;
import lombok.NonNull;

/**
 * Player service interface.
 *
 * @author SShankunas
 */
public interface PlayerService extends CrudService<Player> {

    void transfer(@NonNull UUID id, @NonNull UUID teamId);

    void remove(@NonNull UUID id);

}
