---
  layout: default.md
  title: "Project Portfolio Page"
---

# Project: Staff-Snap

> ***Craigton Lian's*** *Project Portfolio Page*<br>

## Overview
**Staff-Snap** is a desktop hiring management application used for managing applicants during the recruitment cycle. The user interacts with it using a CLI, and it has a GUI created with JavaFX. It is written in Java, and has about 9,000 lines of code.

<br>

## Summary of Contributions

<box type="tip">

The blue tags <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/121" class="badge rounded-pill bg-primary">\#121</a> represent an external link to the corresponding GitHub issue.<br>
The green tags <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/74" class="badge rounded-pill bg-success">\#74</a> represent an external link to the corresponding Pull Request.

</box>

* **Interview Management Features**: Added the `addi`, `editi`, and `deletei` command.
  * **What it does**: Allows the user to add, edit, and delete interviews for each applicant.
  * **Justification**: This feature forms the core functionality of Staff-Snap, as it allows the user to manage the interview process for each applicant, while updating the interview rating progressively.
  * **Highlights**: This enhancement had to be carefully designed to ensure that the interview data is stored in a way that is easily accessible and modifiable by the user. Input validation and duplicate handling was also implemented to ensure that the data is consistent and accurate.
  * **Credits**: Automatic duplicate handling under the `addi` function was **not** implemented by me. This was implemented by my teammate [Austin Huang](https://ay2324s1-cs2103t-w08-1.github.io/tp/team/austinhuang1203.html).

<br>

* **Import CSV Feature**: Added the `import` command.
  * **What it does**: Allows the user to import a correctly-formatted CSV file containing applicant data into Staff-Snap.
  * **Justification**: This feature allows the users to directly import large amounts of applicant data into Staff-Snap using a common file format like CSV instead of manually keying in the data.
  * **Highlights**: This enhancement required careful and thorough error handling and input validation in order to prevent erroneous data from being added into Staff-Snap. 
  * **Credits**: The third-party library [OpenCSV](https://opencsv.sourceforge.net/) was used to parse the input CSV in the implementation of this feature.

<br>

* **Code contributed**: [Craigton Lian's RepoSense link](https://nus-cs2103-ay2324s1.github.io/tp-dashboard/?search=craigtonlian&breakdown=true)

  <iframe src="https://nus-cs2103-ay2324s1.github.io/tp-dashboard/#/widget/?search=craigtonlian&breakdown=false&sort=groupTitle%20dsc&sortWithin=title&since=2023-09-22&timeframe=commit&mergegroup=&groupSelect=groupByRepos&chartGroupIndex=0&chartIndex=0" frameBorder="0" width="800px" height="148px"></iframe>

<br>

* **Project management**:
  * Managed [releases](https://github.com/AY2324S1-CS2103T-W08-1/tp/releases) `v1.2`, `v1.2.1`, `v1.3`, and `v1.4` on GitHub
  * Managed team's [Project Board](https://github.com/orgs/AY2324S1-CS2103T-W08-1/projects/1) on GitHub to ensure steady and consistent progress

<br>

* **Enhancements to existing features**:
  * Updated the logo for Staff-Snap <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/74" class="badge rounded-pill bg-success">\#74</a>
  * Updated the Applicant Card to display icons <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/105" class="badge rounded-pill bg-success">\#105</a>
  * Updated the GUI to display Interview Cards <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/111" class="badge rounded-pill bg-success">\#111</a>
  * Updated the `help` command to open the User Guide in the browser <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/75" class="badge rounded-pill bg-success">\#75</a>

<br>

* **Documentation**:
  * User Guide:
    * Added documentation for the features `addi`, `editi`, `deletei` and `import` <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/80" class="badge rounded-pill bg-success">\#80</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/90" class="badge rounded-pill bg-success">\#90</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/117" class="badge rounded-pill bg-success">\#117</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/140" class="badge rounded-pill bg-success">\#140</a>
    * Did cosmetic tweaks to existing documentation of features `help`, `edit` <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/67" class="badge rounded-pill bg-success">\#67</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/138" class="badge rounded-pill bg-success">\#138</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/145" class="badge rounded-pill bg-success">\#145</a>
  * Developer Guide:
    * Added implementation details of the Interview Management features such as `addi`, `editi`, and `deletei` <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/118" class="badge rounded-pill bg-success">\#118</a>

<br>

* **Community**:
  * PRs reviewed (with non-trivial review comments) <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/110" class="badge rounded-pill bg-success">\#110</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/121" class="badge rounded-pill bg-success">\#121</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/125" class="badge rounded-pill bg-success">\#125</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/129" class="badge rounded-pill bg-success">\#129</a>  
  * Contributed to forum discussions <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/121" class="badge rounded-pill bg-primary">\#121</a> <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/158" class="badge rounded-pill bg-primary">\#158</a> <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/228" class="badge rounded-pill bg-primary">\#228</a> <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/267" class="badge rounded-pill bg-primary">\#267</a>

<br>

* **Tools**:
  * Integrated a third-party library ([OpenCSV](https://opencsv.sourceforge.net/)) to the project <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/300" class="badge rounded-pill bg-primary">\#300</a> <a href="https://github.com/AY2324S1-CS2103T-W08-1/tp/pull/126" class="badge rounded-pill bg-success">\#126</a>
  * Integrated a new GitHub CD workflow ([Netlify Deploy Previews](https://docs.netlify.com/site-deploys/deploy-previews/)) to the team repo to preview deployments to the User Guide and Developer Guide <a href="https://github.com/nus-cs2103-AY2324S1/forum/issues/228" class="badge rounded-pill bg-primary">\#228</a>
