package com.plmarket;

import com.plmarket.api.player.PlayerController;
import com.plmarket.api.team.TeamController;
import com.plmarket.db.embedded.EmbeddedDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@EmbeddedDb
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class PlayerServiceBootApplicationTests {

    @Autowired
    protected PlayerController playerController;

    @Autowired
    protected TeamController teamController;

}
