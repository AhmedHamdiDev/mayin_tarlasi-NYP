import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * AppAssets — Loads and exposes all media assets (images + sounds).
 *
 * Call loadAsync() once at startup; it spawns a background thread so the
 * UI can appear before the assets finish loading.
 */
public class AppAssets {

    // ── Asset paths ────────────────────────────────────────────────────────────
    private static final String ASSET_BAYRAK        = "assets/bayrak.png";
    private static final String ASSET_MAYIN         = "assets/mayin.png";
    private static final String ASSET_KALP          = "assets/kalp.png";
    private static final String ASSET_LEBLEBI       = "assets/leblebi.png";
    private static final String ASSET_ALTIN_LEBLEBI = "assets/altin_leblebi.png";
    private static final String ASSET_YILAN         = "assets/yilan.png";
    private static final String ASSET_ALARM         = "assets/alarm.png";
    private static final String ASSET_ALARM2        = "assets/alarm2.png";
    private static final String ASSET_ALTIN         = "assets/altin.png";
    private static final String ASSET_CARPI         = "assets/carpi.png";
    private static final String ASSET_EKSTRA_CAN    = "assets/ekstra_can.png";
    private static final String ASSET_GUNES         = "assets/gunes.png";
    private static final String ASSET_ILAC          = "assets/ilac.png";
    private static final String ASSET_INFO          = "assets/info.png";
    private static final String ASSET_KAFATASI      = "assets/kafatasi.png";
    private static final String ASSET_KARGA         = "assets/karga.png";
    private static final String ASSET_KUM_SAATI     = "assets/kum_saati.png";
    private static final String ASSET_KUPA          = "assets/kupa.png";
    private static final String ASSET_MUTLU         = "assets/mutlu.png";
    private static final String ASSET_OFF_BTN       = "assets/off_btn.png";
    private static final String ASSET_OK            = "assets/ok.png";
    private static final String ASSET_OYUN_BITTI    = "assets/oyun_bitti.png";
    private static final String ASSET_RESET_BTN     = "assets/reset_btn.png";
    private static final String ASSET_SES_AYARI     = "assets/ses_ayari.png";
    private static final String ASSET_SES_KAPA      = "assets/ses_kapa.png";
    private static final String ASSET_TIK           = "assets/tik.png";
    private static final String ASSET_YILDIZ        = "assets/yildiz.png";
    private static final String ASSET_YILDIZ2       = "assets/yildiz2.png";

    // ── Images ─────────────────────────────────────────────────────────────────
    Image imgBayrak;
    Image imgMayin;
    Image imgKalp;
    Image imgLeblebi;       // Normal leblebi hücresi ikonu
    Image imgAltinLeblebi;  // Altın leblebi hücresi ikonu
    Image imgYilan;         // Yılan (mayın) hücresi ikonu
    Image imgAlarm;         // Alarm / uyarı ikonu
    Image imgAlarm2;        // Alternatif alarm ikonu
    Image imgAltin;         // Altın / para ikonu
    Image imgCarpi;         // Çarpı / hata ikonu
    Image imgEkstraCan;     // Ekstra can ikonu
    Image imgGunes;         // Güneş / bonus ikonu
    Image imgIlac;          // Zirai ilaç ikonu
    Image imgInfo;          // Bilgi ikonu
    Image imgKafatasi;      // Kafatası / tehlike ikonu
    Image imgKarga;         // Karga ikonu
    Image imgKumSaati;      // Kum saati / süre ikonu
    Image imgKupa;          // Kupa / başarım ikonu
    Image imgMutlu;         // Mutlu yüz / kazanma ikonu
    Image imgOffBtn;        // Kapat / çıkış butonu ikonu
    Image imgOk;            // Ok / onay ikonu
    Image imgOyunBitti;     // Oyun bitti ekranı ikonu
    Image imgResetBtn;      // Sıfırlama butonu ikonu
    Image imgSesAyari;      // Ses ayarı ikonu
    Image imgSesKapa;       // Sesi kapat ikonu
    Image imgTik;           // Tik / tamamlandı ikonu
    Image imgYildiz;        // Yıldız / puan ikonu
    Image imgYildiz2;       // Alternatif yıldız ikonu

    // ── Sound effects ──────────────────────────────────────────────────────────
    AudioClip sesKazma;
    AudioClip sesPatlama;
    AudioClip sesButon;
    AudioClip sesKazan;
    AudioClip sesBasla;

    // Market sesleri ve Yilan
    AudioClip sesMarket; // Varsayılan
    AudioClip sesMarketKarga;
    AudioClip sesMarketSaat;
    AudioClip sesMarketIlac;
    AudioClip sesMarketKalp;
    AudioClip sesYilan;
    AudioClip sesYilanBitis;
    AudioClip sesCiftlik;

    // ── Background Music (BGM) ─────────────────────────────────────────────────
    MediaPlayer bgmKlasik;
    MediaPlayer bgmSatranc;
    MediaPlayer bgmLeblebi;
    private MediaPlayer aktifBgm;
    private String bekleyenBgm = null;

    // ── Volume reference ───────────────────────────────────────────────────────
    private AppState appState;

    /** Sets the AppState reference so play() can read sesHacmi. */
    public void setAppState(AppState state) {
        this.appState = state;
    }

    // ── Public API ─────────────────────────────────────────────────────────────

    /** Spawns a background thread that loads all images and audio clips. */
    public void loadAsync() {
        Thread t = new Thread(() -> {
            imgBayrak       = loadImage(ASSET_BAYRAK,        18);
            imgMayin        = loadImage(ASSET_MAYIN,         20);
            imgKalp         = loadImage(ASSET_KALP,          20);
            imgLeblebi      = loadImage(ASSET_LEBLEBI,       20);
            imgAltinLeblebi = loadImage(ASSET_ALTIN_LEBLEBI, 20);
            imgYilan        = loadImage(ASSET_YILAN,         20);
            imgAlarm        = loadImage(ASSET_ALARM,         20);
            imgAlarm2       = loadImage(ASSET_ALARM2,        20);
            imgAltin        = loadImage(ASSET_ALTIN,         20);
            imgCarpi        = loadImage(ASSET_CARPI,         20);
            imgEkstraCan    = loadImage(ASSET_EKSTRA_CAN,    20);
            imgGunes        = loadImage(ASSET_GUNES,         20);
            imgIlac         = loadImage(ASSET_ILAC,          20);
            imgInfo         = loadImage(ASSET_INFO,          20);
            imgKafatasi     = loadImage(ASSET_KAFATASI,      20);
            imgKarga        = loadImage(ASSET_KARGA,         20);
            imgKumSaati     = loadImage(ASSET_KUM_SAATI,     20);
            imgKupa         = loadImage(ASSET_KUPA,          20);
            imgMutlu        = loadImage(ASSET_MUTLU,         20);
            imgOffBtn       = loadImage(ASSET_OFF_BTN,       20);
            imgOk           = loadImage(ASSET_OK,            20);
            imgOyunBitti    = loadImage(ASSET_OYUN_BITTI,    20);
            imgResetBtn     = loadImage(ASSET_RESET_BTN,     20);
            imgSesAyari     = loadImage(ASSET_SES_AYARI,     20);
            imgSesKapa      = loadImage(ASSET_SES_KAPA,      20);
            imgTik          = loadImage(ASSET_TIK,           20);
            imgYildiz       = loadImage(ASSET_YILDIZ,        20);
            imgYildiz2      = loadImage(ASSET_YILDIZ2,       20);
            sesKazma = loadClip("sounds/kazma.mp3");
            sesPatlama = loadClip("sounds/patlama.mp3");
            sesButon = loadClip("sounds/buton.mp3");
            sesMarket = loadClip("sounds/market.mp3");
            sesKazan = loadClip("sounds/kazan.mp3");
            sesBasla = loadClip("sounds/sesBasla.mp3");

            sesMarketKarga = loadClip("sounds/karga.mp3");
            sesMarketSaat = loadClip("sounds/saat.mp3");
            sesMarketIlac = loadClip("sounds/ilac.mp3");
            sesMarketKalp = loadClip("sounds/kalp.mp3");
            sesYilan = loadClip("sounds/yilan.mp3");
            sesYilanBitis = loadClip("sounds/yilan_bitis.mp3");
            sesCiftlik = loadClip("sounds/ciftlik.mp3");

            // MediaPlayer nesneleri JavaFX Application Thread üzerinde oluşturulmalıdır
            javafx.application.Platform.runLater(() -> {
                bgmKlasik = loadBgm("sounds/bgm_klasik.mp3");
                bgmSatranc = loadBgm("sounds/bgm_satranc.mp3");
                bgmLeblebi = loadBgm("sounds/bgm_leblebi.mp3");
                if (bekleyenBgm != null) {
                    playBgm(bekleyenBgm);
                    bekleyenBgm = null;
                }
            });
        }, "asset-loader");
        t.setDaemon(true);
        t.start();
    }

    /** Plays a clip at the current volume (no-op if null). */
    public void play(AudioClip klip) {
        if (klip != null) {
            double vol = (appState != null) ? appState.sesHacmi : 0.7;
            klip.play(vol);
        }
    }

    /**
     * Plays a clip at a custom volume multiplier relative to the global volume.
     * For example, play(clip, 0.5) plays at half of the global volume.
     */
    public void play(AudioClip klip, double carpan) {
        if (klip != null) {
            double vol = (appState != null) ? appState.sesHacmi * carpan : 0.7 * carpan;
            klip.play(Math.min(1.0, Math.max(0.0, vol)));
        }
    }

    public void stop(AudioClip klip) {
        if (klip != null) klip.stop();
    }

    // ── Private helpers ────────────────────────────────────────────────────────

    private Image loadImage(String yol, double boyut) {
        try {
            java.net.URL url = getClass().getResource(yol);
            if (url == null)
                url = java.nio.file.Paths.get(yol).toAbsolutePath().toUri().toURL();
            return new Image(url.toString(), boyut, boyut, true, false, true);
        } catch (Exception e) {
            return null;
        }
    }

    private AudioClip loadClip(String yol) {
        try {
            // 1. Try classpath resource (relative to class)
            java.net.URL url = getClass().getResource(yol);
            // 2. Try classpath resource (absolute — from classpath root)
            if (url == null)
                url = getClass().getResource("/" + yol);
            // 3. Try relative to the source/class file location
            if (url == null) {
                java.net.URL classLoc = getClass().getProtectionDomain().getCodeSource().getLocation();
                if (classLoc != null) {
                    java.io.File base = new java.io.File(classLoc.toURI());
                    java.io.File f = new java.io.File(base, yol);
                    if (f.exists())
                        url = f.toURI().toURL();
                }
            }
            // 4. Try relative to working directory
            if (url == null) {
                java.io.File f = new java.io.File(yol);
                if (f.exists())
                    url = f.toURI().toURL();
            }
            // 5. Try src/ subfolder (common for IDE runs)
            if (url == null) {
                java.io.File f = new java.io.File("src", yol);
                if (f.exists())
                    url = f.toURI().toURL();
            }
            if (url != null) {
                return new AudioClip(url.toString());
            }
            System.err.println("[AppAssets] Ses dosyası bulunamadı: " + yol);
            return null;
        } catch (Exception e) {
            System.err.println("[AppAssets] Ses yüklenirken hata (" + yol + "): " + e.getMessage());
            return null;
        }
    }

    private MediaPlayer loadBgm(String path) {
        try {
            java.net.URL url = AppAssets.class.getResource("/" + path);
            if (url == null) {
                java.io.File f = new java.io.File("src", path);
                if (f.exists()) url = f.toURI().toURL();
            }
            if (url == null) {
                java.io.File f = new java.io.File(path);
                if (f.exists()) url = f.toURI().toURL();
            }

            if (url != null) {
                Media media = new Media(url.toExternalForm());
                MediaPlayer player = new MediaPlayer(media);
                player.setCycleCount(MediaPlayer.INDEFINITE);
                if (appState != null) {
                    player.setVolume(appState.muzikSessiz ? 0 : appState.muzikHacmi);
                }
                return player;
            }
        } catch (Exception e) {
            System.err.println("BGM yuklenemedi: " + path);
        }
        return null;
    }

    // ── BGM API ────────────────────────────────────────────────────────────────

    public void playBgm(String mod) {
        if (bgmKlasik == null) {
            bekleyenBgm = mod;
            return;
        }

        if (aktifBgm != null)
            aktifBgm.stop();

        switch (mod) {
            case "klasik" -> aktifBgm = bgmKlasik;
            case "satranc" -> aktifBgm = bgmSatranc;
            case "leblebi" -> aktifBgm = bgmLeblebi;
            default -> aktifBgm = null;
        }

        if (aktifBgm != null) {
            updateBgmVolume();
            aktifBgm.play();
        }
    }

    public void stopBgm() {
        if (aktifBgm != null) {
            aktifBgm.stop();
            aktifBgm = null;
        }
    }

    public void updateBgmVolume() {
        if (appState != null) {
            double v = appState.muzikSessiz ? 0.0 : appState.muzikHacmi;
            if (bgmKlasik != null)
                bgmKlasik.setVolume(v);
            if (bgmSatranc != null)
                bgmSatranc.setVolume(v);
            if (bgmLeblebi != null)
                bgmLeblebi.setVolume(v);
        }
    }
}
