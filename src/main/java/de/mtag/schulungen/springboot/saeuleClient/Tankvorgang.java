package de.mtag.schulungen.springboot.saeuleClient;

import java.util.UUID;

public class Tankvorgang {

    private UUID vorgangsNummer;

    public Tankvorgang(UUID vorgangsNummer){
        this.vorgangsNummer = vorgangsNummer;
    }

    public UUID getVorgangsNummer() {
        return vorgangsNummer;
    }

    public void setVorgangsNummer(UUID vorgangsNummer) {
        this.vorgangsNummer = vorgangsNummer;
    }

}
