# JShell
```bash
jshell
```

## Get Help
```bash
jshell> /help
|  Type a Java language expression, statement, or declaration.
|  Or type one of the following commands:
|  /list [<name or id>|-all|-start]
|  	list the source you have typed
|  /edit <name or id>
|  	edit a source entry
|  /drop <name or id>
|  	delete a source entry
|  /save [-all|-history|-start] <file>
|  	Save snippet source to a file
|  /open <file>
|  	open a file as source input
|  /vars [<name or id>|-all|-start]
|  	list the declared variables and their values
|  /methods [<name or id>|-all|-start]
|  	list the declared methods and their signatures
|  /types [<name or id>|-all|-start]
|  	list the type declarations
|  /imports 
....
```

## Search in history
- Control + R to search backward commands.
- This borrows from unix shell

```bash
<press tab again to see next page>
jshell> System.out.println("Hello World!")
Hello World!

jshell> System.out.println("Hello World, nice to meet you!")
Hello World, nice to meet you!

jshell> System.out.println("Hello World, nice to meet you!")
bck-i-search: wor_
```

## Static import to make shortcut

```bash
jshell> /open PRINTING

jshell> printf("Hello Vung")
Hello Vung
jshell> 

```

## Set default

```bash
jshell> /set start -retain DEFAULT PRINTING
```

## Edit method
```bash
jshell> /set editor vi
|  Editor set to: vi
```

## Create some object

```bash
jshell> record Person(String fname, String lname){}
|  created record Person

jshell> List<Person> ppl = new ArrayList<>()
ppl ==> []

jshell> ppl.add(new Person("Vung", "Do"))
$3 ==> true
```
