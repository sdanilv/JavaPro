package Client;

/**  -cmd list  просмотреть список юзеров и их статус
 *   -cmd logout статус вышел
 *   -cmd in статус на месте
 *   -room roomName войти в комнату roomName
 *   -to userName личное сообщение  userName
 */

public class Main {

    public static void main(String[] args) {
        ClientConsole.getLoginAndPass();
        startReceivingMessage();
        ClientConsole.startSendingMessage();
    }

    private static void startReceivingMessage() {
        Thread thread = new Thread(new GetThread());
        thread.setDaemon(true);
        thread.start();
    }
}
