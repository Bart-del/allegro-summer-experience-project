# Allegro summer experience project


### English below


## Spis Treści
* [O projekcie](#o-projekcie)
* [Technologie](#technologie)
* [Instalacja](#instalacja)
* [Jak to działa?](#jak-to-działa)
* [Potencjalne kierunki rozwoju](#potencjalne-kierunki-rozwoju)

## O projekcie

Projekt powstał w ramach zadania rekrutacyjnego na stanowisko Intern Software Engineer w programie Allegro Summer E-Xperience. Zadanie brzmiało:

```
Projekt nr. 3

Stwórz oprogramowanie pozwalające na:
- listowanie repozytoriów (nazwa i liczba gwiazdek),
- zwracanie sumy gwiazdek we wszystkich repozytoriach,
dla dowolnego użytkownika serwisu GitHub.
Dane powinny być zwracane za pomocą protokołu HTTP.
```

Wszystkie wymagania projektu zostały zrealizowane, a kod udostępniam na swoim koncie GitHub.

## Technologie

W projekcie użyłem następujących technologii:

* Java w wersji 11.02
* Framework Spring w wersji 2.4.5
* Biblioteka Unirest do nawiązania połączenia z API Github'a

## Instalacja

Instalacja może przebiegać w różny sposób, w zależności od dostepnego środowiska. W przypadku tradycyjnych serwerów, na przykład tomcat najprostrzym sposobem jest:

* pobranie wygenrowanego pliku war,
* przeniesienie go do folderu tomcat/webapps/
* z poziomu terminala w folderze tomcat/bin uruchomić polecenie "catalina.bat run" w systemie Windows, natomiast w systemach Unixowych "catalina.sh run"

## Jak to działa?

Po instalacji i uruchomieniu aplikacji na serwerze dane są zwracane poprzez endpoint "/api/github_data?user=przykładowy_użytkownik_githuba". Przykładowy adres wyglądałby w ten sposób:
```
https://adres_ip_serwera/api/github_data?user=Bart-del
```
Aplikacja zwróci nazwy moich wszystkich publicznych repozytoriów oraz gwiazdek w formacie JSON używając protokołu HTTP.

## Potencjalne kierunki rozwoju

Projekt w obecnym stanie nie jest zbyt rozbudowany, jednak może stanowić dobrą bazę do dalszego rozwoju. Przyszłe potencjalne funkcje mogą obejmowac na przykład:
* Poszerzenie zwracanych danych o dodakowe informacje o repozytoriach danego użytkownika i nie tylko
* Zbieranie statystyk o wszelkich projektach open source w celach badawczych
* Badanie kierunku rozwoju oraz trendów w open source korzystając z dodatkowych danych, które udostępnia GitHub w swoim API
* Stworzenie serwisu internetowego, lub aplikacji mobilnej, która wykorzysta udostępniane dane i przedstawi je w estetyczny sposób


## Table of contents
* [General info](#about-project)
* [Technologies](#technologies)
* [Setup](#setup)
* [How it works](#how-it-works)
* [Future development](#future-development)

## About project

The project was created as part of a recruitment task for the position of Intern Software Engineer in the Allegro Summer E-Xperience program. The task was:

```
Project no. 3

Create software that allows you to:
- listing of repositories (name and number of stars),
- returning the sum of stars in all repositories,
for any GitHub user.
Data should be returned using the HTTP protocol. 
```

All project requirements have been fulfilled and the code is available on my GitHub account. 
	
## Technologies

In the project, I used the following technologies:

* Java version 11.02
* Framework Spring version 2.4.5
* Unirest library to connect to the Github API 
	
## Setup

Installation can take different steps depending on the available environment. For traditional servers, such as tomcat, the easiest way is to:

* download a generated war file,
* moving it to the tomcat / webapps / folder
* from the terminal level in the tomcat / bin folder run the command "catalina.bat run" in Windows, and in Unix systems "catalina.sh run" 

## How it works?

After installing and running the application on the server, the data is returned via endpoint "/api/github_data?user=exemplary_github_user". An example address would look like this:
```
https://server_ip_address/api/github_data?user=Bart-del
```
The application will return the names of all my public repositories and asterisks in JSON format using the HTTP protocol. 

## Future development

The project in its current state is not very extensive, but it can constitute a good basis for further development. Future potential features may include, for example:
* Extending the returned data with additional information about the repositories of a given user and more
* Collecting statistics on any open source projects for research purposes
* Research on the direction of development and trends in open source using additional data that GitHub provides in its API
* Creating a website or a mobile application that will use the shared data and present it in an aesthetic way 