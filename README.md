IdFusion™ Sandbox
=================
MVP client web application exposing a small set of features in order to provide the means for developer-UX-UI peers collaboration.

This sample is to be extended in the future on a daily/weekly/monthly basis.

Building, Running and Packaging
-------------------------------
This project has be created using **gwt-maven-plugin 2.8.2 archtype** and it is **primarily a [Maven](https://maven.apache.org/) project**. 
The `pom.xml` file covers the following aspects(for now):

1. **Profile management**

2. **Dependencies**

3. **Java compilation**

4. **Plugin configuration; e.g. `less` & `sass` plugins need forker attention if he/she decides to go with a post-processed superset instead of plain CSS**

5. **GWT setup, compilation**


Development, setup and run
-----------------------------------
`mvn clean compile gwt:compile gwt:run`


Current business logic
----------------------
 - The header of the default screen contains a search container which is used to filter the data collection below 
 - Upon load the a collection of person items is being rendered in `grid view' mode as per default
 - Each item in the collection will contain both: static and action data
 - In the grid/table header you will notice a button labeled `Switch View Mode`. Clicking it will toggle between the 2, for now, possible view modes: `grid view` and `table view`
 - You will also notice another button: `Reset` - which when clicked will reset the data in the grid/table to its default range; e.g. 0/first
 - The footer container holds the `Fetch more...` button, which when clicked will load the next range of data items

To be extended....

@designer
---------
Implement a clean, smooth, cool, great looking, responsive, also usable on small screens/devices,... design. 
The rest is up to you...



@cristi_cola -> feel free to add more requirements and/or explanations....
