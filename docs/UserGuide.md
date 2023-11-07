---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---
<style>
img
{
    display:block;
    float:none;
    margin-left:auto;
    margin-right:auto;
}
</style>

<a name="staff-snap-user-guide"></a>
# Staff-Snap User Guide

--- {.double}

[//]: # (<!-- * Table of Contents -->)
[//]: # (<page-nav-print />)

<a name="table-of-contents"></a>
## Table of Contents

* [Introduction](#introduction)
* [Quick Start](#quick-start)
* [Using this Guide](#using-this-guide)
  * [Understanding the Notations](#understanding-the-notations)
  * [Understanding the Main Window GUI](#understanding-the-main-window-gui)
  * [Understanding the Applicant Card GUI](#understanding-the-applicant-card-gui)
* [Features](#features)
  * [Applicant Management Features](#applicant-management-features)
    * [Command Parameters](#command-parameters-1)
    * [Adding a new applicant: `add`](#add)
    * [Editing an applicant: `edit`](#edit)
    * [Deleting an applicant: `delete`](#delete)
    * [Listing all applicants: `list`](#list)
    * [Editing an applicant status: `status`](#status)
  * [Interview Management Features](#interview-management-features)
    * [Command Parameters](#command-parameters-2)
    * [Adding an interview to an applicant: `addi`](#addi)
    * [Editing an interview of an applicant: `editi`](#editi)
    * [Deleting an interview from an applicant: `deletei`](#deletei)
  * [Applicant Processing Features](#applicant-processing-features)
    * [Command Parameters](#command-parameters-3)
    * [Finding an applicant by name: `find`](#find)
    * [Sorting applicants by descriptors: `sort`](#sort)
    * [Filtering applicants by fields: `filter`](#filter)
    * [Importing from csv: `import`](#import)
  * [Miscellaneous Features](#miscellaneous-features)
    * [Viewing help: `help`](#help)
    * [Clearing all applicant entries: `clear`](#clear)
    * [Exiting the program: `exit`](#exit)
    * [Saving the data](#saving-the-data)
    * [Editing the data file](#editing-the-data-file)
* [FAQ](#faq)
* [Glossary](#glossary)

---
<br>

<a name="introduction"></a>
## Introduction

Welcome to the **Staff-Snap** User Guide!

**Staff-Snap** is a desktop app for Hiring Managers like you to manage the hiring and tracking of applicants, optimised for use via a [Command Line Interface (CLI)](#glossary). Used by hiring managers in companies around the globe, it is effective, easy-to-use and reliable, making the hiring process a much more enjoyable experience.

The purpose of this guide is to get you familiar with the features of **Staff-Snap** - from the very basics, to the most advanced features the application has to offer. These features range from the simple task of adding an applicant to being able to calculate an applicant's score from their ratings in the interview stages. Every single feature is explained in this guide. You can check out the [Table of Contents](#table-of-contents) to navigate to a feature you might be interested in using.

To begin using this guide, ensure you meet the [minimum system requirements](#minimum-system-requirements). Once this is done, go to the [quick start](#quick-start) section to get the app up and running. Once you have done so, please feel free to go through the features sections to find out what features Staff-Snap has installed. We recommend going through it in the order of this guide but any order works as well! You may check out our table of contents to jump to any section of your choice.

<br>

---
<br>

## Minimum System Requirements
1. A Computer running Windows/MacOS/Linux.
2. Java 11 or higher
   1. If you do not have Java 11, follow [this](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A) installation guide.


<br>

---
<br>

## Need help?
If you are unable to follow any of the steps below or get help, please email our CEO at staffsnap@gmail.com or call our 24/7 technical helpline 69696969 for assistance. (For educational purposes, not real contact details.)

<br>

---
<br>

<a name="quick-start"></a>
## Quick Start 

1. Download the latest `staffsnap.jar` from [here](https://github.com/AY2324S1-CS2103T-W08-1/tp/releases/tag/v1.3).
2. Copy the [JAR](#glossary) file to an empty folder that you would like to use as the [home folder](#glossary) for Staff-Snap.
3. Open the [command terminal](#glossary).
4. Navigate into your home folder with the `cd` command.
5. Enter the `java -jar staffsnap.jar` command to run the application.
6. You should see the [GUI](#glossary) displayed as shown below. Note how the application contains some sample data.<br>

   ![Main Window view](images/user-guide/MainWindow.png)

7. Type the [command](#glossary) in the command box and press <kbd>Enter</kbd> to execute it. e.g. typing `help` and pressing <kbd>Enter</kbd> will open this User Guide in your browser window. Some example commands that you can try:
   * `add n/John Doe hp/81238123 p/Boss e/john@mail.com` : Adds an applicant named John Doe to the list. 
   * `list` : Lists all applicants.
   * `delete 1` : Deletes the 1st applicant shown in the current list.
   * `clear` : Clears all applicants from the list.
   * `exit` : Exits the application.

<br>

9. Refer to the [Features](#features) below for details of each command.

<box type="tip" header="**For macOS users**" seamless>

If you are unfamiliar with the command terminal, you can right-click the `staffsnap.jar` file and select **Open With > JavaLauncher.app** to launch the application. If you are shown the warning below, click Open to continue launching Staff-Snap.<br>

<img src="images/user-guide/mac_os_warning.png" height="400" width="334" alt="mac_os_warning">

</box>

---
<br>

<a name="using-this-guide"></a>
## Using this Guide

---
<br>

This section introduces the symbols and notations used throughout this guide. We recommend that you read this section closely before using this guide.

<a name="understanding-the-notations"></a>
### Understanding the Notations

| Notation                                                                                                                     | Explanation                                                                                               | Example                                                                                                                                            |
|------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| Words in `UPPER_CASE`                                                                                                        | These are the parameters to be supplied by the user.                                                      | The command format `addi INDEX t/TYPE r/RATING` can be used in the form `addi 1 t/behavioural r/9.8` with the necessary details as the parameters. |
| Items in square brackets                                                                                                     | These are optional parameters for the users to supply.                                                    | The command `find KEYWORD [MORE_KEYWORDS]` can be used in the form `find Johnny Lee` as well as `find Johnny`                                      |
| Parameters can be in any order                                                                                               | Parameters for all commands are valid regardless of the order they are supplied in.                       | Both the commands `add n/Lee Soo Man hp/98891131…` and `add hp/98891131 n/Lee Soo Man…` are valid and will be accepted.                            |
| Extraneous parameters for commands that do not take in parameters such as `help`, `list`, `clear`, `exit` will be ignored.   | If any parameters are given for commands that do not require them, the given parameters will be ignored.  |

<br>

---
<br>

<a name="understanding-the-main-window-gui"></a>
### Understanding the Main Window GUI

<br>

![Main Window guide](images/user-guide/MainWindowGuide.png)

<br>

| <div style="width:130px">GUI Component</div> | <div style="width:auto">Purpose</div>                                    |
|----------------------------------------------|--------------------------------------------------------------------------|
| Command Area                                 | This is where users type in commands for the application.                |
| Response Area                                | This is where Staff-Snap displays messages in response to user commands. |
| Working Area                                 | This is where the applicant list is displayed.                           |

<br>

---
<br>

<a name="understanding-the-applicant-card-gui"></a>
### Understanding the Applicant Card GUI

<br>

![Applicant Card guide](images/user-guide/ApplicantCardGuide.png)

<br>

| <div style="width:130px">GUI Component</div> | Purpose                                                                                                                                |
|----------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| Applicant details                            | This is where details about the applicant are displayed. These include their name, phone number, email, and position applied.          |
| Applicant status                             | This is where the status of the applicant is displayed. The status is categorised into Offered, Rejected, or Undecided.                |
| Overall score                                | This is where the overall score of the applicant is displayed. This represents the _average_ rating of all the applicant's interviews. |
| Interview rating                             | This is where the rating for a each interview is displayed.                                                                            |

---
<br>

<a name="features"></a>
## Features

---
<br>

This section introduces the full-suite of features in Staff-Snap. The features are grouped according to the following categories:
1. [Applicant Management Features](#applicant-management-features)
2. [Interview Management Features](#interview-management-features)
3. [Applicant Processing Features](#applicant-processing-features)
4. [Miscellaneous Features](#miscellaneous-features)

<br>

<a name="applicant-management-features"></a>
### Applicant Management Features

<br>

<a name="command-parameters-1"></a>
#### Command Parameters

| Parameter  | Description​                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | Examples​                                                        |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| `NAME`     | The applicant's name.<br/> <br/> It can only contain alphanumeric characters and space, should be at least 1 character long, and should not exceed 25 characters.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | <ul><li>`James Lee`</li><li>`Rosemary Lee Curtis`</li></ul>      |
| `PHONE`    | The applicant's phone number. <br/> <br/> It can only contain numbers, should be at least 3 digits long, and should not exceed 30 digits.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | <ul><li>`91234726`</li><li>`1234567890123`</li></ul>             |
| `EMAIL`    | The applicant's email. <br/> <br/> It should be of the format **local-part@domain**. <br/><br/> The **local-part** should only contain alphanumeric characters and these special characters, excluding the parentheses, (+_.-). The **local-part** may not start or end with any special characters. <br/><br/> This is followed by a **'@'** and then a **domain name**. The **domain name** is made up of domain labels separated by periods. The domain name must end with a domain label at least 2 characters long, have each domain label start and end with alphanumeric characters, and have each domain label consist of alphanumeric characters, separated only by hyphens, if any. <br/><br/> The entire email address should not exceed 30 characters. | <ul><li>`james@gmail.com`</li><li>`e9867626@u.nus.edu`</li></ul> |
| `POSITION` | The position applied for by the applicant. <br/> <br/> It can take any value, should not be blank and should not exceed 30 characters.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | <ul><li>`Software Engineer`</li><li>`AI Architect 2`</li></ul>   |
| `STATUS`   | The status of the applicant. <br/> <br/> It can only be `o` or `offered` for _OFFERED_, `r` or `rejected` for _REJECTED_, or `u` or `undecided` for _UNDECIDED_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | <ul><li>`o`</li><li>`u`</li><li>`rejected`</li></ul>             |
| `INDEX`    | The index of the applicant in the displayed list. <br/> <br/> It must be a positive integer and not more than the total number of applicants.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | <ul><li>`2`</li></ul>                                            |



<br>

---
<br>

<a name="add"></a>
#### Adding a new applicant: `add`

Adds a new applicant to the list.

Format: `add n/NAME hp/PHONE e/EMAIL p/POSITION`

<box type="warning" header="**Caution**">
    Duplicate applicants are not allowed. Two applicants are considered duplicates if they have the same phone number or email.
</box>

<box type="tip" header="**Note**">
    As <code>NAME</code> can only contain alphanumeric characters and spaces, names containing hyphens <code>-</code> or slashes <code>/</code> are not allowed in this version of the app.  
</box>


Example:
* `add n/John Doe hp/91234567 e/johndoe@gmail.com p/Software Engineer`
* `add n/Jane Greenwood p/Project Manager e/janeg@yahoo.com hp/81234567`

<br>

---
<br>

<a name="edit"></a>
#### Editing an applicant: `edit`

Edits the details of an applicant in the list.

Format: `edit INDEX [n/NAME] [hp/PHONE] [e/EMAIL] [p/POSITION]`
* Edits the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.
* At least one of the optional fields must be provided.
* Existing values will be updated by the input values.

Example:
* `edit 1 n/Vijay Sankar Kumar` edits the name of the 1st applicant in the list.
* `edit 2 hp/80081234 e/newEmail@hotmail.com` edits the phone number and email of the 2nd applicant in the list.

<br>

---
<br>

<a name="delete"></a>
#### Deleting an applicant: `delete`

Deletes an applicant from the list.

Format: `delete INDEX`
* Deletes the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.

Example:
* `list` followed by `delete 2` deletes the 2nd person in the applicant list.
* `sort d/name` followed by `delete 3` deletes the 3rd person in the sorted applicant list.

<br>

---
<br>

<a name="list"></a>
#### Listing all applicants: `list`

Displays the full list of all applicants.

Format: `list`

<br>

---
<br>

<a name="status"></a>
#### Editing an applicant status: `status`

Edits the status of an applicant.

Format: `status INDEX s/STATUS`
* Edits the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.
* `STATUS` must be either `o`(offered) or `r`(rejected) or `u`(undecided).

Example:
* `status 3 s/o` updates the status of the 3rd person in the displayed applicant list to _OFFERED_.

<br>

---

<br>

<a name="interview-management-features"></a>
### Interview Management Features

<br>

<a name="command-parameters-2"></a>
#### Command Parameters

| Parameter         | Description​                                                                                                                                                          | Examples​                                          |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| `TYPE`            | The interview type.<br/> <br/> It should not be empty and should not exceed 14 characters.                                                                            | <ul><li>`technical`</li><li>`behavioral`</li></ul> |
| `RATING`          | The interview rating. <br/> <br/> It should be a number between 0.0 and 10.0 inclusive, to 1 decimal place.                                                           | <ul><li>`9.6`</li><li>`0.0`</li></ul>              |
| `INTERVIEW_INDEX` | The index of the applicant's interview in the applicant card. <br/> <br/> It must be a positive integer and not more than the applicant's total number of interviews. | <ul><li>`1`</li><li>`2`</li></ul>                  |
| `INDEX`           | The index of the applicant in the displayed list. <br/> <br/> It must be a positive integer and not more than the total number of applicants.                         | <ul><li>`2`</li></ul>                              |


<br>

---
<br>

<a name="addi"></a>
#### Adding an interview to an applicant: `addi`

Adds a new interview to an applicant. In the case of duplicate names, the system will automatically increment the last 
number in the user input until it hits a unique input, or add 1 if there is no number. However, if the input is too
large, or there are too many duplicates, the system might throw a message asking you to handle it manually without 
handling it for you.

Note: The name change is permanant so removing previous interviews will not change back the name. That is if both
`technical1` and `technical2` exist, deleting `technical1` will not change `technical2` back to `technical1`.

Duplicate handling: 
* Entering `technical12`, then `technical12` again will result in the 2nd entry being converted to 
`technical13`.
* Entering `technical`, `technical1`, then `technical` again will result in the 2nd `technical` entry being 
converted to `technical2`.
* Entering `technical`, then `technical` again will result in the 2nd entry being converted to `technical1`.

Format: `addi INDEX t/TYPE [r/RATING]`
* Adds an interview to the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.
* A maximum of 5 interviews can be added to each applicant.

Example:
* `addi 1 t/technical r/8.6` adds a Technical interview with rating 8.6 to the 1st person in the displayed applicant list.
* `addi 3 t/screening` adds a Screening interview without rating to the 3rd person in the displayed applicant list.

<box type="warning" header="**Caution**">
    Rating will be rounded to the nearest 1 decimal place if more than 1 decimal place is provided.
</box>

![addi.png](images/user-guide/addi.png)

<br>

---
<br>

<a name="editi"></a>
#### Editing an interview of an applicant: `editi`

Edits an interview of an applicant.

Format: `editi INDEX i/INTERVIEW_INDEX [t/TYPE] [r/RATING]`
* Edits the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.
* At least one of the optional fields must be provided.
* Existing values will be updated by the input values.

Example:
* `editi 1 i/1 t/technical r/7.8` edits the 1st interview of the 1st person in the displayed applicant list to a technical interview with rating 7.8.
* `editi 3 i/2 t/screening` edits the 2nd interview type of the 3rd person in the displayed applicant list to a screening interview.
* `editi 2 i/1 r/8.9` edits the 1st interview rating of the 2nd person in the displayed applicant list to 8.9.

<br>

---
<br>

<a name="deletei"></a>
#### Deleting an interview from an applicant: `deletei`

Deletes an interview from an applicant.

Format: `deletei INDEX i/INTERVIEW_INDEX`
* Deletes from the applicant at the specified `INDEX`. The index refers to the index number shown in the displayed applicant list.

Example:
* `deletei 1 i/2` deletes the 2nd interview of the 1st person in the displayed applicant list.

<br>

---
<br>

<a name="applicant-processing-features"></a>
### Applicant Processing Features

<br>

<a name="command-parameters-3"></a>
#### Command Parameters

| Parameter    | Description​                                                                                                                           | Examples​                                                |
|--------------|----------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| `DESCRIPTOR` | The applicant descriptor to sort by.<br/> <br/> It should be either `name` or `phone` or `email` or `position` or `score` or `status`. | <ul><li>`name`</li><li>`score`</li></ul>                 |
| `KEYWORD`    | The keyword to find in an applicant's name. <br/> <br/> It should be alphanumeric.                                                     | <ul><li>`Lee`</li><li>`Zhang Jordan`</li></ul>           |
| `SCORE`      | The applicant's overall score. <br/> <br/> It should be a number between 0.0 and 10.0 inclusive, to 1 decimal place.                   | <ul><li>`0.0`</li><li>`8.3`</li></ul>                    |
| `FILENAME`   | The file name of the csv file to import. <br/> <br/> It should end with the `.csv` suffix and should not be blank.                     | <ul><li>`demo.csv`</li><li>`applicantBook.csv`</li></ul> |


<br>

---
<br>

<a name="find"></a>
#### Finding an applicant by name: `find`

Find employees whose name contains a particular keyword.

Format: `find KEYWORD [MORE_KEYWORDS]`
* The search is case-insensitive, e.g. `JOHN` will return `john`.
* The order of the keywords does not matter, e.g. `Alice Tan` will match `Tan Alice`.
* Only the applicant name is searched.
* Any applicant whose name contains the sequence of characters given as the keyword will be given as a result, e.g. `Ed` will match both `Edward` and `Ed`.
* Applicants matching at least one keyword will be returned (i.e. OR search), e.g. `Ben Bobby` will return `Ben Yang`, `Bobby Chin`.

Example:
* `find IVAN` finds any applicant whose name contains “ivan”.
* `find IVAN CHEW` finds any applicant whose name contains “ivan” or contains “chew”.

<br>

---
<br>

<a name="sort"></a>
#### Sorting applicants by descriptors: `sort`

Sorts the applicant list based on the descriptor provided.

Format: `sort d/DESCRIPTOR [dsc/]`
* `DESCRIPTOR` must be either `name` or `phone` or `email` or `position` or `score` or `status`.
* `dsc/` flag indicates to sort the applicant list in descending order.

Example:
* `sort d/name` sorts the applicant list by name in alphabetical order.
* `sort d/phone` sorts the applicant list by phone numbers in ascending order.
* `sort d/email` sorts the applicant list by email in alphabetical order.
* `sort d/position dsc/` sorts the applicant list by positions in descending alphabetical order.
* `sort d/score dsc/` sorts the applicant list by score in descending order.
* `sort d/status` sorts the applicant list by status in the order _UNDECIDED_, _OFFERED_, _REJECTED_.

<br>

---
<br>

<a name="filter"></a>
#### Filtering applicants by fields: `filter`

Filters the applicant list based on fields given by the user.

Format: `filter [n/NAME] [e/EMAIL] [p/POSITION] [hp/PHONE] [s/STATUS] [lts/SCORE] [gts/SCORE]`
* All fields are optional, however at least one of the optional fields must be provided.
* Any combination of multiple different fields is allowed.
* Only one of each field can be provided.
* Only applicants matching all fields will be returned. (i.e. AND search).
* for `[n/NAME]` field, only applicants whose name contains the full substring will be returned, e.g. `n/Ivan Chew` will **NOT** return `Ivan Lee`.
* `[n/NAME]` `[e/EMAIL]` `[p/POSITION]` fields are case-insensitive, e.g. `n/JOHN` will return `john`.
* If provided, the fields `NAME`, `PHONE`, `EMAIL`, and `POSITION` must satisfy the [parameter constraints](#command-parameters-1) previously described.
* `[lts/SCORE]` `[gts/SCORE]` fields include equality in filters, e.g. `gts/7` will return all applicants whose score is greater than or equal to `7`.

Example:
* `filter n/Ivan` filters the applicant list to applicants whose name contains `ivan`.
* `filter n/Ivan p/Testing Engineer s/u` filters applicant list to applicants whose name contains `ivan` applying for the role of `testing engineer` and has a status of `Undecided`.
* `filter gts/7` filters applicant list to applicants whose score is greater than or equal to `7`.


<br>

---
<br>

<a name="import"></a>
#### Importing from CSV: `import`

Imports applicants from a [CSV](#glossary) file.

Format: `import f/FILENAME`
* The CSV file must be placed in the home folder of Staff-Snap.
* The CSV file must have the following headers: `name`, `phone`, `email`, `position` in that order, as shown below.<br>
  
<img src="images/user-guide/csv_header.png" alt="mac_os_warning">

* The fields of the columns must satisfy the [parameter constraints](#command-parameters-1) for `NAME`, `PHONE`, `EMAIL`, and `POSITION` respectively.
* A sample CSV file can be found [here](demo.csv).

Example:
* `import f/demo.csv`

<br>

---

<br>

<a name="miscellaneous-features"></a>
### Miscellaneous Features

<br>

<a name="help"></a>
#### Viewing help: `help`

Opens up the user guide in the browser. Also displays a list of basic commands the user can use.

Format: `help`

<br>

<a name="clear"></a>
#### Clearing all applicant entries: `clear`

After typing `clear`, system asks the user to confirm clearing. If user types `yes` and clicks enter, 
all the current data stored in the system is then cleared. 
Else, typing in anything else then pressing enter will cancel the clear process. 

Format: `clear`

![Clear UI Mockup](images/user-guide/clear.png)

<br>

<a name="exit"></a>
#### Exiting the program: `exit`

Exits the program.

Format: `exit`

<br>

<a name="saving-the-data"></a>
#### Saving the data

Automatically saves the data to a local storage whenever there is a change to the applicant list. There is no need to save manually.

<br>

<a name="editing-the-data-file"></a>
#### Editing the data file

<box type="warning" header="**Caution**">
    Please make a backup copy before you attempt to edit the data file. If the format of the edited data file is invalid, Staff-Snap will override the existing data file with an empty data file in the next run. 
</box>

Staff-Snap applicant data are saved automatically as a [JSON](#glossary) file `[JAR file location]/data/applicantBook.json`. Advanced users are welcome to update data directly by editing that data file.

<br>

---
<br>

<a name="faq"></a>
## FAQ

**Q**: How do I transfer my data to another Computer? <br>
**A**: There are 2 methods you can use to transfer your data.
- Method 1: Clear the current data using the [`clear`](#clearing-all-applicant-entries-clear) command and import your data using the [`import`](#importing-from-csv-import) command.
- Method 2: Copy the data file `[JAR file location]/data/applicantBook.json` to the other computer.

**Q**: Is my data secure? <br> 
**A**: Yes, your data is stored locally in your computer and is not accessible by anyone else.

<br>

---
<br>

<a name="glossary"></a>
## Glossary

| Term                              | Definition                                                                                                                                     |
|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| Parameter                         | Parameters are the details needed to perform a specific command. (e.g. When adding an applicant, a parameter can be the name of the applicant) |
| Command                           | A Command is an instruction given by the user to perform a certain action.                                                                     |
| Index                             | The position of a certain applicant in a list. The first applicant on a list in Staff-Snap will always have the index 1.                       |
| User Interface (UI)               | An User Interface is the visual display of the application where users can interact with the application.                                      |
| Graphical User Interface (GUI)    | The GUI is the visual display of the application which users can interact with.                                                                |
| Command Line Interface (CLI)      | The CLI is a text-based interface that allows users to type in commands to interact with the application.                                      |
| Component                         | A component is part of the user interface.                                                                                                     |
| Alphanumeric                      | Text that is consisting of or using both letters and numerals.                                                                                 |
| JAR                               | A JAR file is a Java Archive file. It is a package file format typically used to aggregate many Java class files and associated metadata.      |
| Java                              | Java is a general-purpose, class-based, object-oriented programming language designed for having lesser implementation dependencies.           |
| Home folder                       | The main folder where you want to store all Staff-Snap related files.                                                                          |
| Small medium enterprise (SME)     | A small medium enterprise is a business that maintains revenues, assets, or number of employees below a certain threshold.                     |
| Comma-separated values (CSV)      | A CSV file is a comma-separated values file, which allows data to be saved in a tabular format.                                                |
| Prefix                            | A prefix is a word, letter, or number placed before another.                                                                                   |
| JavaScript Object Notation (JSON) | A data interchange file format used by Staff-Snap to store its applicant data.                                                                 |
