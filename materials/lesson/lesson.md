# Первая программа
Для того, чтобы написать свою первую программу на Java, нужно выполнить всего несколько несложных действий и осознать пару простых понятий. Сейчас мы разберемся, как создать свой Java-проект в Intellij IDEA, где писать код, какой код писать и как запустить программу.

Первым делом нам необходимо создать Java-проект. По сути java-проект - это просто папка, в которой лежат текстовые файлы и другие папки с определенными именами и содержимым. Если папка имеет соответствующее содержимое, то ее можно открыть в intellij idea, как java-проект и работать с файлами в ней, используя все возможности этой среды разработки. Но по сути java код можно писать и просто в блокноте – другой вопрос, что это очень медленно и требует множества дополнительных действий, чтобы запустить такую программу. То есть в реальности java-код - это просто текст, но специальные программы, такие как Intellij IDEA, умеют представлять и читать его определенным образом.

Итак, чтобы создать новый java-проект, можно использовать Intellij IDEA, которая создаст для нас правильную структуру папок, все необходимые файлы с правильными именами и содержимым, чтобы мы могли приступить к написанию кода.

Для этого откроем intellij idea и нажмем create new project.

![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/a55fa84c-e669-4e03-806d-d480e23e18cb/1.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T091857Z&X-Amz-Expires=86400&X-Amz-Signature=1603bc4fd3d44e197ff78b569a2793901474a41559e8451c7ec18543cef75cef&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%221.png%22&x-id=GetObject)

В списке слева мы выбираем Java. Это простейший способ создания проекта на java. Все прочие требуют дополнительных действий. Для project SDK выбираем тот, который мы скачали ранее.

![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/93ad883f-22e2-45a0-b209-68c43b09a81f/2.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092009Z&X-Amz-Expires=86400&X-Amz-Signature=e3c00dc272dbd5db14ea96bc691a4660823b7cdf8d2fb6c86529c0e9c8928f75&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%222.png%22&x-id=GetObject)
Если вы не скачали, то вам стоит посмотреть ролик про установку всего необходимого. Нажимаем add JDK, если по умолчанию у вас не появилась опция в списке, указываем путь до вашего jdk. Теперь можем нажать next.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/bfd64b47-e552-4c17-9c91-3be2cdc1a398/3.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092106Z&X-Amz-Expires=86400&X-Amz-Signature=0e579bf3425bf6a88d74266f3502ad900b74a2e5af147f080f5343d5021ca0e8&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%223.png%22&x-id=GetObject)
Здесь все оставим, как есть, ничего не выбираем, нажимаем next.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/58edcc4e-0a8c-45ba-b02c-8d08351c0e2d/4.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092132Z&X-Amz-Expires=86400&X-Amz-Signature=b3a8b2972969feaa80825b66e4150b5d7d6dfbd97eed4ca122f3653599abcb7e&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%224.png%22&x-id=GetObject)
Назовем наш проект как-нибудь. Например, my-first-project. Писать следует на латинице, не используя пробелы. Жмем finish.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/86e21730-098a-495c-8d88-53f26b5c7603/5.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092156Z&X-Amz-Expires=86400&X-Amz-Signature=cb13a89704d295aaa46e7f4fa84a475f301287db85264c3e821626f7a7d041fc&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%225.png%22&x-id=GetObject)
Все, наш проект успешно создан. Посмотрим на его наполнение. В меню слева видно название нашего проекта. Как мы уже сказали, это просто папка с другими папками и файлами внутри. Развернем ее.

Внутри мы видим две папки и один файл. Папка .idea создается нашей средой разработки, и в ней находятся различные файлы, помогающие нам эффективно работать с кодом в Intellij idea. Нас же интересует папка src, которая отмечена синим цветом. Src это сокращение от английского слова source, которое означает «источник». То есть в этой папке будет находиться наш исходный код, наша программа.

Вообще папки в java называются пакетами, поэтому далее мы будем использовать это слово, чтобы вы постепенно привыкали к терминам.

Прямо сейчас пакет src пуст. Давайте создадим в нем еще один пакет, где будем размещать наш код. Делаем это просто для лучшей организации кода и файлов. Жмем правой кнопкой на пакет src, выбираем new…, кликаем package.

Теперь нужно указать имя создаваемого пакета. Если вы хотите создать сразу несколько пакетов один в другом, то их имена можно указывать через точку. Давайте создадим сразу два пакета один в другом. Напишем com.idoit и нажмем enter.

Мы получили два пакета: com и внутри него idoit. Прекрасно.

Но код – это текст. Текст мы обычно пишем в текстовых файлах. Такие файлы в java имеют расширение .java и находятся внутри пакета src и его подпакетах. Файлы с расширением .java называют java-классами. Давайте создадим наш первый класс.

Нажмем правой кнопкой на нашем новом пакете idoit, выберем new и нажмем class. Нужно указать имя, пусть будет App. Жмем enter.

Итак, что произошло. Слева мы видим наш новый файл App.java. И он открыт в нашей среде разработки, где мы видим уже какой-то код, который intellij idea добавила по умолчанию. Здесь описан класс App (на это указывает ключевое слово class). Внутри фигурных скобок после его названия ничего больше нет, поэтому этот класс пока пуст.

Важно запомнить: java-файлы – это классы. Имя java-файла должно всегда совпадать с именем класса в коде внутри. Имена классов пишутся всегда с большой буквы, как и имена файлов соответственно, раз уж должны совпадать. Если имя класса состоит из нескольких слов, то каждое новое слово пишется с большой буквы без разделения слов пробелами.

Теперь напишем немного кода сами. Любой код должен быть написан внутри какого-либо класса. «Внутри» значит внутри фигурных скобок, которые идут после его названия. Поэтому перейдем на следующую строку внутри нашего класса.

Программы на java запускаются с помощью специальной конструкции, которая называется метод main. Позднее мы разберемся, что такое метод, и что такое именно метод main, но пока мы просто запустим нашу первую программу.

Итак, чтобы создать точку запуска программы – метод main – есть специальное сокращение, которое предоставляет intellij idea. Начинаем писать psvm.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/10aadb61-12da-4123-8aa1-71197e1a7192/6.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092227Z&X-Amz-Expires=86400&X-Amz-Signature=4e86398fe582bc78da0d8bb8e0088783678a2014ed3c5ae2e1568a653bf77a5d&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%226.png%22&x-id=GetObject)
Idea предложит нам эту комбинацию в выпадающем меню. Выбираем и жмем enter. И вот налицо прелесть использования профессиональной среды разработки вместо блокнота. Из четырех символов мы автоматически получили множество слов и символов. В блокноте нам бы пришлось писать все руками.

Т.о. у нас есть точка запуска программы. Все, что находится внутри фигурных скобок этого блока является нашей рабочей программой и будет выполняться, когда мы запустим ее. В сущности, мы можем запустить нашу программу уже сейчас, но ничего не произойдет, потому что что наш метод main пустой – внутри фигурных скобок не написано никаких команд. Это скучно.

Давайте выполним хотя бы одну команду. Традиционно принято в первой программе выводить на консоль строчку Hello World или здравствуй мир. Сделаем это. Для этого напишем следующий код: System.out.println();
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/ad70ef5b-1aa3-4fd1-8b9a-179c00d99791/7.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092247Z&X-Amz-Expires=86400&X-Amz-Signature=f47d8fb81c779957eef76dcece3ac14352212d8fae81dfd000fff036d5d65ed0&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%227.png%22&x-id=GetObject)
Это специальная команда вывода информации на консоль. Позднее мы рассмотрим ее подробнее и поймем, как она работает, но пока не имеет смысла усложнять. Внутри круглых скобок мы должны написать, что именно нужно вывести на консоль. Мы хотели вывести строчку hello world, поэтому давайте напишем именно это.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/75fad01a-4f91-49a6-ade5-4a3fa6c4bafa/8.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092311Z&X-Amz-Expires=86400&X-Amz-Signature=335f0d6de5cbb06e3e74ad7c0754c590917dc50d5cdc996aa2ce7bc45866a893&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%228.png%22&x-id=GetObject)
Важно: команды в java пишутся просто как обычный текст в редакторе. Но если мы хотим написать строчку, то есть какое-то фактическое значение, набор символов, а не инструкцию для компьютера, то мы должны поместить ее внутри двойных кавычек.

Теперь можем нажать значок запуска и взглянуть на результат выполнения нашей программы. Жмем зеленый треугольник напротив метода main и выбираем “Run App.main”.
![alt text](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/c15448ba-95df-4177-b0e9-b3943ff39ae9/9.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221120%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221120T092339Z&X-Amz-Expires=86400&X-Amz-Signature=092dc46051a4b63617e588646101063b48965efa5ab06b69b2d1d143acc7e528&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%229.png%22&x-id=GetObject)
Как видите, в консоли появилась строчка hello world. Когда мы нажали зеленый треугольник – кнопку запуска – выполнился весь код, который написан внутри фигурных скобок метода main. Обычно в одной программе один метод main, чтобы была единственная точка запуска, но бывают и исключения.

В данном случае внутри этих фигурных скобок написана лишь одна команда для компьютера: выведи на экран слова «hello world». Именно их мы и видим на консоли intellij idea.

Запуск java программы всегда происходит методом main. Если у вас есть множество файлов с кучей кода и всего прочего, то вы никогда не сможете их запустить, пока не напишите метод main, где опишите необходимые действия.

В следующем ролике мы подробнее познакомимся с классами и объектами, которые создаются на основе классов.