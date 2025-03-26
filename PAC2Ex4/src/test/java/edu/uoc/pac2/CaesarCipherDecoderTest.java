package edu.uoc.pac2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CaesarCipherDecoderTest {

    @Test
    @Order(1)
    @DisplayName("Minimum - calculateFrequency")
    public void testCalculateFrequency() {
        int[] frequency = CaesarCipherDecoder.calculateFrequency("ABCD");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("HELLO");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("THIS IS A TEST MESSAGE WITH SPACES AND SYMBOLS, LIKE COMMAS.");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{5, 1, 2, 1, 5, 0, 1, 2, 4, 0, 1, 2, 4, 1, 2, 1, 0, 0, 10, 4, 0, 0, 1, 0, 1, 0}, frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("A-LONG-SENTENCE-WITH-NUMBERS-123456");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{1, 1, 1, 0, 4, 0, 1, 1, 1, 0, 0, 1, 1, 4, 1, 0, 0, 1, 2, 2, 1, 0, 1, 0, 0, 0}, frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[26], frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("1234 !@#$%^&*()-_=+[]{}|;:'\",.<>?/`~");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[26], frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, frequency);

        frequency = CaesarCipherDecoder.calculateFrequency("aBcDeFgHiJkLmNoPqRsTuVwXyZ");
        assertEquals(26, frequency.length);
        assertArrayEquals(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}, frequency);
    }

    @Test
    @Order(2)
    @DisplayName("Advanced - findMostFrequentLetter")
    public void testFindMostFrequentLetter() {
        assertEquals('A', CaesarCipherDecoder.findMostFrequentLetter("ABCD"));
        assertEquals('L', CaesarCipherDecoder.findMostFrequentLetter("HELLO"));
        assertEquals('S', CaesarCipherDecoder.findMostFrequentLetter("THIS IS A TEST MESSAGE WITH SPACES AND SYMBOLS, LIKE COMMAS."));
        assertEquals('E', CaesarCipherDecoder.findMostFrequentLetter("A-LONG-SENTENCE-WITH-NUMBERS-123456"));
        assertEquals('A', CaesarCipherDecoder.findMostFrequentLetter(""));
        assertEquals('A', CaesarCipherDecoder.findMostFrequentLetter("1234 !@#$%^&*()-_=+[]{}|;:'\",.<>?/`~"));
        assertEquals('A', CaesarCipherDecoder.findMostFrequentLetter("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals('B', CaesarCipherDecoder.findMostFrequentLetter("aBcDeFgHiJkLmNoPqRsTuVwXyZ"));
        assertEquals('E', CaesarCipherDecoder.findMostFrequentLetter("HERE WE SEE THE TREES SWAYING GENTLY UNDER THE BREEZE. EVERY LEAF SEEMS EAGER TO GREET THE EVENING."));
        assertEquals('O', CaesarCipherDecoder.findMostFrequentLetter("ROBO GO COO DRO DBOOC CGKISXQ QOXDVI EXNOB DRO LBOOJO. OFOBI VOKP COOWC OKQOB DY QBOOD DRO OFOXSXQ."));
        assertEquals('Y', CaesarCipherDecoder.findMostFrequentLetter("BYLY QY MYY NBY NLYYM MQUSCHA AYHNFS OHXYL NBY VLYYTY. YPYLS FYUZ MYYGM YUAYL NI ALYYN NBY YPYHCHA."));
    }

    @Test
    @Order(3)
    @DisplayName("Advanced - calculateShift")
    public void testCalculateShift() {
        assertEquals(22, CaesarCipherDecoder.calculateShift("ABCD"));
        assertEquals(7, CaesarCipherDecoder.calculateShift("HELLO"));
        assertEquals(14, CaesarCipherDecoder.calculateShift("THIS IS A TEST MESSAGE WITH SPACES AND SYMBOLS, LIKE COMMAS."));
        assertEquals(0, CaesarCipherDecoder.calculateShift("A-LONG-SENTENCE-WITH-NUMBERS-123456"));
        assertEquals(22, CaesarCipherDecoder.calculateShift(""));
        assertEquals(22, CaesarCipherDecoder.calculateShift("1234 !@#$%^&*()-_=+[]{}|;:'\",.<>?/`~"));
        assertEquals(22, CaesarCipherDecoder.calculateShift("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals(23, CaesarCipherDecoder.calculateShift("aBcDeFgHiJkLmNoPqRsTuVwXyZ"));
        assertEquals(0, CaesarCipherDecoder.calculateShift("HERE WE SEE THE TREES SWAYING GENTLY UNDER THE BREEZE. EVERY LEAF SEEMS EAGER TO GREET THE EVENING."));
        assertEquals(10, CaesarCipherDecoder.calculateShift("ROBO GO COO DRO DBOOC CGKISXQ QOXDVI EXNOB DRO LBOOJO. OFOBI VOKP COOWC OKQOB DY QBOOD DRO OFOXSXQ."));
        assertEquals(20, CaesarCipherDecoder.calculateShift("BYLY QY MYY NBY NLYYM MQUSCHA AYHNFS OHXYL NBY VLYYTY. YPYLS FYUZ MYYGM YUAYL NI ALYYN NBY YPYHCHA."));
    }

    @Test
    @Order(4)
    @DisplayName("Advanced - decryptMessage")
    public void testDecryptMessage() {
        assertEquals("EVERYWHERE THE WIND WHISPERS THROUGH THE TREES, ECHOING THE ETERNAL SILENCE OF THE EVENING.", CaesarCipherDecoder.decryptMessage("GXGTAYJGTG VJG YKPF YJKURGTU VJTQWIJ VJG VTGGU, GEJQKPI VJG GVGTPCN UKNGPEG QH VJG GXGPKPI."));
        assertEquals("ELEPHANTS ENTER THE ENORMOUS FOREST, EAGERLY SEEKING SHELTER AND FOOD TO EASE THEIR HUNGER.", CaesarCipherDecoder.decryptMessage("MTMXPIVBA MVBMZ BPM MVWZUWCA NWZMAB, MIOMZTG AMMSQVO APMTBMZ IVL NWWL BW MIAM BPMQZ PCVOMZ."));
        assertEquals("THE SUNSET SEEMED ENDLESS, CASTING GOLDEN AND ORANGE HUES ACROSS THE SERENE WATERS OF THE LAKE.", CaesarCipherDecoder.decryptMessage("IWT HJCHTI HTTBTS TCSATHH, RPHIXCV VDASTC PCS DGPCVT WJTH PRGDHH IWT HTGTCT LPITGH DU IWT APZT."));
        assertEquals("EACH NEW EXPERIENCE ENRICHES THE HEART AND MIND, OFFERING ENDLESS OPPORTUNITIES TO EXPLORE.", CaesarCipherDecoder.decryptMessage("CYAF LCU CVNCPGCLAC CLPGAFCQ RFC FCYPR YLB KGLB, MDDCPGLE CLBJCQQ MNNMPRSLGRGCQ RM CVNJMPC."));
        assertEquals("EVEN THE SMALLEST DETAILS OF LIFE CAN OFFER EXTRAORDINARY MOMENTS OF PEACE AND ENLIGHTENMENT.", CaesarCipherDecoder.decryptMessage("KBKT ZNK YSGRRKYZ JKZGORY UL ROLK IGT ULLKX KDZXGUXJOTGXE SUSKTZY UL VKGIK GTJ KTROMNZKTSKTZ."));
    }

}
