# CPU_Test
# 1. Add the library to run JavaFX
    Click on File->Project Structure->Libraries and add a new Java library and
    select the JavaFX path. path/to/javafx-sdk1x.x.x/lib
    
# 2. Add a new Path Variable
    Click on File->Settings->Appereance & Behavior and go to Path Variables and add a new one,
    named PATH_TO_FX, containing the path path/to/javafx-sdk1x.x.x/lib
    
   
# 3. Click on Run->Edit Configurations
    Click on the "plus sign" and select Application
    Select Application
    Add as main class sample.Main
 
# 4. Add VM Options
    Click on Run->Edit Configurations and select VM Options
    Add the following text :
    --module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml


