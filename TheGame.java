
public class TheGame {

    public static void main(String[] args) {
        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        boolean languageCheck = true;
        boolean GameRunning = true;
        System.out.println("Please choose you're language before starting the game: ");
        System.out.println("{Danish, English, Kurdish & Turkish}");
        String language = "";

        while (languageCheck) {
            language = scanner.nextLine();
            if (language.equalsIgnoreCase("danish") || language.equalsIgnoreCase("english") || language.equalsIgnoreCase("kurdish") || language.equalsIgnoreCase("turkish")) {
                languageCheck = false;
            } else {
                System.out.println("Please choose a valid language");
            }
        }

        System.out.println();
        System.out.println(Translate.Output(language, "description"));
        System.out.println();
        System.out.println(Translate.Output(language, "enterplayer1"));
        String player1_name = scanner.nextLine();
        var Player1 = new PlayerCreate(player1_name, 1000);
        System.out.println();
        System.out.println(Translate.Output(language, "enterplayer2"));
        String player2_name = scanner.nextLine();
        var Player2 = new PlayerCreate(player2_name, 1000);

        while (GameRunning) {
            System.out.println();
            System.out.println(player1_name + Translate.Output(language, "turn"));
            var Press1 = scanner.nextLine();
            if (Press1.isEmpty()) {
                int Player1_dice1_value = Player1.DiceValue1();
                int Player1_dice2_value = Player1.DiceValue2();
                System.out.println(Translate.Output(language, "dice1") + Player1_dice1_value);
                System.out.println(Translate.Output(language, "dice2") + Player1_dice2_value);
                System.out.println(player1_name + Translate.Output(language, "totalmoney") + Player1.SumCounter(Player1_dice1_value, Player1_dice2_value, language));
            }

            System.out.println();
            System.out.println(player2_name + Translate.Output(language, "turn"));
            var Press2 = scanner.nextLine();
            if (Press2.isEmpty()) {
                int Player2_dice1_value = Player2.DiceValue1();
                int Player2_dice2_value = Player2.DiceValue2();
                System.out.println(Translate.Output(language, "dice1") + Player2_dice1_value);
                System.out.println(Translate.Output(language, "dice2") + Player2_dice2_value);
                System.out.println(player2_name + Translate.Output(language, "totalmoney") + Player2.SumCounter(Player2_dice1_value, Player2_dice2_value, language));
            }

            if (Player1.Money >= 3000) {
                System.out.println();
                System.out.println(player1_name + Translate.Output(language, "win"));
                GameRunning = false;
            } else if (Player2.Money >= 3000) {
                System.out.println();
                System.out.println(player2_name + Translate.Output(language, "win"));
                GameRunning = false;
            } else if (Player1.Money <= 0) {
                System.out.println();
                System.out.println(player1_name + Translate.Output(language, "lost"));
                GameRunning = false;
            } else if (Player2.Money <= 0) {
                System.out.println();
                System.out.println(player2_name + Translate.Output(language, "lost"));
                GameRunning = false;
            }

        }
        scanner.close();
    }
}

class Translate {

    public static String Output(String language, String text) {
        String Output = "";

        if (language.equalsIgnoreCase("english")) {
            if (text.equals("win")) {
                Output = " has won the game!";
            } else if (text.equals("lost")) {
                Output = " has lost the game!";
            } else if (text.equals("totalmoney")) {
                Output = "'s Total money is: ";
            } else if (text.equals("dice1")) {
                Output = "Dice number 1, value: ";
            } else if (text.equals("dice2")) {
                Output = "Dice number 2, value: ";
            } else if (text.equals("turn")) {
                Output = "'s turn: ";
            } else if (text.equals("enterplayer1")) {
                Output = "Enter player 1's name: ";
            } else if (text.equals("enterplayer2")) {
                Output = "Enter player 2's name: ";
            } else if (text.equals("description")) {
                Output = "The game is a fun and competitive dice-rolling experience for two players. Each player takes turns rolling two dice, trying to accumulate Moneys based on the sum of their rolls. Different sums correspond to unique game events that can either benefit or hinder the players. The first player to reach 3000 Moneys wins the game. A player loses if their Moneys fall below 0. You play by pressing enter.";
            } else if (text.equals("Tower")) {
                Output = "You have achieved the value of a Tower!";
            } else if (text.equals("Crater")) {
                Output = "You have achieved the value of a Crater!";
            } else if (text.equals("Palace gates")) {
                Output = "You have achieved the value of a Palace gate!";
            } else if (text.equals("Cold Desert")) {
                Output = "You have achieved the value of a Cold Desert!";
            } else if (text.equals("Walled city")) {
                Output = "You have achieved the value of a Walled city!";
            } else if (text.equals("Monastery")) {
                Output = "You have achieved the value of a Monastery!";
            } else if (text.equals("Black cave")) {
                Output = "You have achieved the value of a Black cave";
            } else if (text.equals("Huts in the mountain")) {
                Output = "You have achieved the value of a Huts in the mountain!";
            } else if (text.equals("The Werewall")) {
                Output = "You have achieved the value of a The Werwall!";
            } else if (text.equals("The pit")) {
                Output = "You have achieved the value of a The pit!";
            } else if (text.equals("Goldmine")) {
                Output = "You have achieved the value of a Goldmine!";
            } else if (text.equals("Confirm")) {
                Output = "The transaction was a success";
            }
        } else if (language.equalsIgnoreCase("danish")) {
            if (text.equals("win")) {
                Output = " har vundet spillet!";
            } else if (text.equals("lost")) {
                Output = " har tabt spillet!";
            } else if (text.equals("totalmoney")) {
                Output = "'s Totale penge kasse er: ";
            } else if (text.equals("dice1")) {
                Output = "Terning nummer 1, værdi: ";
            } else if (text.equals("dice2")) {
                Output = "Terning nummer 2, værdi: ";
            } else if (text.equals("turn")) {
                Output = "'s tur: ";
            } else if (text.equals("enterplayer1")) {
                Output = "Indtast Enter player 1's navn: ";
            } else if (text.equals("enterplayer2")) {
                Output = "Indtast Enter player 2's navn: ";
            } else if (text.equals("description")) {
                Output = "Spillet er en sjov og konkurrencepræget terningkastoplevelse for to spillere. Hver spiller skiftes til at kaste to terninger og forsøge at samle penge baseret på summen af deres kast. Forskellige summer svarer til unikke spilbegivenheder, der enten kan gavne eller hæmme spillerne. Den første spiller, der når 3000 kroner, vinder spillet. En spiller taber, hvis deres penge falder under 0. Du spiller ved at trykke på enter.";
            } else if (text.equals("Tower")) {
                Output = "Du har opnået værdien af et Tårn!";
            } else if (text.equals("Crater")) {
                Output = "Du har opnået værdien af et Krater!";
            } else if (text.equals("Palace gates")) {
                Output = "Du har opnået værdien af en Paladsport!";
            } else if (text.equals("Cold Desert")) {
                Output = "Du har opnået værdien af en Kold Ørken!";
            } else if (text.equals("Walled city")) {
                Output = "Du har opnået værdien af en Bymur!";
            } else if (text.equals("Monastery")) {
                Output = "Du har opnået værdien af et Kloster!";
            } else if (text.equals("Black cave")) {
                Output = "Du har opnået værdien af en Sort Hule!";
            } else if (text.equals("Huts in the mountain")) {
                Output = "Du har opnået værdien af Hytter i bjergene!";
            } else if (text.equals("The Werewall")) {
                Output = "Du har opnået værdien af Werewallen!";
            } else if (text.equals("The pit")) {
                Output = "Du har opnået værdien af Gruben!";
            } else if (text.equals("Goldmine")) {
                Output = "Du har opnået værdien af en Guldmine!";
            } else if (text.equals("Confirm")) {
                Output = "Transaktionen var en succes";
            }
        } else if (language.equalsIgnoreCase("Turkish")) {
            if (text.equals("win")) {
                Output = " oyunu kazandı!";
            } else if (text.equals("lost")) {
                Output = " oyunu kaybetti!";
            } else if (text.equals("totalmoney")) {
                Output = "'nın Toplam puanı: ";
            } else if (text.equals("dice1")) {
                Output = "Zar numarası 1, değeri: ";
            } else if (text.equals("dice2")) {
                Output = "Zar numarası 2, değeri: ";
            } else if (text.equals("turn")) {
                Output = "'nın sırası: ";
            } else if (text.equals("enterplayer1")) {
                Output = "Oyuncu 1'in adını girin: ";
            } else if (text.equals("enterplayer2")) {
                Output = "Oyuncu 2'nin adını girin: ";
            } else if (text.equals("description")) {
                Output = "Oyun, iki oyuncu için eğlenceli ve rekabetçi bir zar atma deneyimidir. Her oyuncu sırayla iki zar atarak atışlarının toplamına göre puan toplamaya çalışır. Farklı toplamlar, oyunculara fayda sağlayabilecek veya zarar verebilecek benzersiz oyun olayları ile ilişkilidir. İlk 3000 puana ulaşan oyuncu oyunu kazanır. Bir oyuncu puanları 0'ın altına düştüğünde kaybeder. Oyunu oynamak için enter tuşuna basmanız yeterlidir.";
            } else if (text.equals("Tower")) {
                Output = "Bir Kule değerine ulaştınız!";
            } else if (text.equals("Crater")) {
                Output = "Bir Krater değerine ulaştınız!";
            } else if (text.equals("Palace gates")) {
                Output = "Bir Saray kapısı değerine ulaştınız!";
            } else if (text.equals("Cold Desert")) {
                Output = "Bir Soğuk Çöl değerine ulaştınız!";
            } else if (text.equals("Walled city")) {
                Output = "Bir Surlu şehir değerine ulaştınız!";
            } else if (text.equals("Monastery")) {
                Output = "Bir Manastır değerine ulaştınız!";
            } else if (text.equals("Black cave")) {
                Output = "Bir Kara mağara değerine ulaştınız!";
            } else if (text.equals("Huts in the mountain")) {
                Output = "Dağdaki kulübeler değerine ulaştınız!";
            } else if (text.equals("The Werewall")) {
                Output = "Bir Kurt Duvarı değerine ulaştınız!";
            } else if (text.equals("The pit")) {
                Output = "Bir Çukur değerine ulaştınız!";
            } else if (text.equals("Goldmine")) {
                Output = "Bir Altın madeni değerine ulaştınız!";
            } else if (text.equals("Confirm")) {
                Output = "işlem başarılı oldu";
            }

        } else if (language.equalsIgnoreCase("Kurdish")) {
            if (text.equals("win")) {
                Output = " oyûnê xweşt kir!";
            } else if (text.equals("lost")) {
                Output = " oyûnê winda kir!";
            } else if (text.equals("totalmoney")) {
                Output = "'a Xalên Tevahî: ";
            } else if (text.equals("dice1")) {
                Output = "Numreya zarê 1, nirx: ";
            } else if (text.equals("dice2")) {
                Output = "Numreya zarê 2, nirx: ";
            } else if (text.equals("turn")) {
                Output = "'a navbêra xwe: ";
            } else if (text.equals("enterplayer1")) {
                Output = "Navê lîstikvanê 1 binivîse: ";
            } else if (text.equals("enterplayer2")) {
                Output = "Navê lîstikvanê 2 binivîse: ";
            } else if (text.equals("description")) {
                Output = "Vê lîstikê, pir xweş û hejmara terningan a berdewam ji bo du lîstikvan e. Her lîstikvan li hev xwe terningên du zêde dikin, hewl dikin ku ji bo xwe xelatên derbas dikin. Mêjûyên cuda yên çend zêdeyên bîr dikin ku dikarin yan jî lîstikvanên xwe alîkarî bikin yan jî qebûl bikin. Yekem lîstikvan ku 3000 xelat pêk tîne, lîstika dikin. Yek lîstikvan têkoşîna xwe dike, ger xelatên wî ji 0 jêr in. Tu lîstika dikî bi hênikê.";
            } else if (text.equals("Tower")) {
                Output = "Ev nirxê Qesra te bi dest xistî!";
            } else if (text.equals("Crater")) {
                Output = "Ev nirxê Qeyaxa te bi dest xistî!";
            } else if (text.equals("Palace gates")) {
                Output = "Ev nirxê Deriyên Sarayê te bi dest xistî!";
            } else if (text.equals("Cold Desert")) {
                Output = "Ev nirxê Çolê Sar te bi dest xistî!";
            } else if (text.equals("Walled city")) {
                Output = "Ev nirxê Bajarê Berdan te bi dest xistî!";
            } else if (text.equals("Monastery")) {
                Output = "Ev nirxê Dêr te bi dest xistî!";
            } else if (text.equals("Black cave")) {
                Output = "Ev nirxê Şîna Reş te bi dest xistî!";
            } else if (text.equals("Huts in the mountain")) {
                Output = "Ev nirxê Kolan di Çiyayan de te bi dest xistî!";
            } else if (text.equals("The Werewall")) {
                Output = "Ev nirxê Dîwarê Qurt te bi dest xistî!";
            } else if (text.equals("The pit")) {
                Output = "Ev nirxê Dehla te bi dest xistî!";
            } else if (text.equals("Goldmine")) {
                Output = "Ev nirxê Kanîya Zerîn te bi dest xistî!";
            } else if (text.equals("Confirm")) {
                Output = "pêşbaza serkeftî bû";
            }

        }

        return Output;
    }
}

class PlayerCreate {

    private int DiceValue1;
    private int DiceValue2;
    public int Money;

    public PlayerCreate(String name, int Money) {
        this.Money = Money;

    }

    public int DiceValue1() {
        this.DiceValue1 = (int) (Math.random() * 6) + 1;
        return this.DiceValue1;
    }

    public int DiceValue2() {
        this.DiceValue2 = (int) (Math.random() * 6) + 1;
        return this.DiceValue2;
    }

    public int SumCounter(int dice1, int dice2, String language) {
        switch (dice1 + dice2) {
            case 2 -> {
                this.Money += 250;
                System.out.println(Translate.Output(language, "Tower"));
            }
            case 3 -> {
                this.Money -= 100;
                System.out.println(Translate.Output(language, "Crater"));
            }
            case 4 -> {
                this.Money += 100;
                System.out.println(Translate.Output(language, "Palace gates"));
            }
            case 5 -> {
                this.Money -= 20;
                System.out.println(Translate.Output(language, "Cold Desert"));
            }
            case 6 -> {
                this.Money += 180;
                System.out.println(Translate.Output(language, "Walled city"));
            }
            case 7 -> {
                this.Money += 0;
                System.out.println(Translate.Output(language, "Monastery"));
            }
            case 8 -> {
                this.Money -= 70;
                System.out.println(Translate.Output(language, "Black cave"));
            }
            case 9 -> {
                this.Money += 60;
                System.out.println(Translate.Output(language, "Huts in the mountain"));
            }
            case 10 -> {
                this.Money -= 80;
                System.out.println(Translate.Output(language, "The Werewall"));
            }
            case 11 -> {
                this.Money -= 50;
                System.out.println(Translate.Output(language, "The pit"));
            }
            case 12 -> {
                this.Money += 650;
                System.out.println(Translate.Output(language, "Goldmine"));
            }
        }
        System.out.println(Translate.Output(language, "Confirm"));
        return this.Money;
    }
}
