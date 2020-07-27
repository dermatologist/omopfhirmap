package com.canehealth.omopfhirmap.utils;

public class OmopConstants {
    public static Integer OMOP_MALE = 8507;
    public static Integer OMOP_FEMALE = 8532;
    public static String LICENSE = "\nomopfhirmap  Copyright (C) 2020  Bell Raj Eapen\n"+
    "This program comes with ABSOLUTELY NO WARRANTY\n" +
    "This is free software, and you are welcome to redistribute it\n"+
    "under certain conditions as detailed in LICENSE file.\n";

    public static String HELPSTRING = "\nUsage:\n"+
    "omopfhirmap function source destination\n"+
    "function = help | tofhirbundle | tofhirserver | toomop\n"+
    "source = cohort id in atlas | bundle json file\n" +
    "destination = bundle json file | fhir server URL\n";

    public static String ASCIIART =  "     \n"  + 
    "     ______     _    _     _____     _____      \n"  + 
    "    |  ____|   | |  | |   |_   _|   |  __ \\     \n"  + 
    "    | |__      | |__| |     | |     | |__) |    \n"  + 
    "    |  __|     |  __  |     | |     |  _  /     \n"  + 
    "    | |        | |  | |    _| |_    | | \\ \\     \n"  + 
    "    |_|        |_|  |_|   |_____|   |_|  \\_\\    \n"  + 
    "                                                \n"  + 
    "                                                \n"  + 
    "       __          __                           \n"  + 
    "      / /          \\ \\                          \n"  + 
    "     / /   ______   \\ \\                         \n"  + 
    "    < <   |______|   > >                        \n"  + 
    "     \\ \\            / /                         \n"  + 
    "      \\_\\          /_/                          \n"  + 
    "                                                \n"  + 
    "                                                \n"  + 
    "      ____      __  __      ____      _____     \n"  + 
    "     / __ \\    |  \\/  |    / __ \\    |  __ \\    \n"  + 
    "    | |  | |   | \\  / |   | |  | |   | |__) |   \n"  + 
    "    | |  | |   | |\\/| |   | |  | |   |  ___/    \n"  + 
    "    | |__| |   | |  | |   | |__| |   | |        \n"  + 
    "     \\____/    |_|  |_|    \\____/    |_|        \n"  + 
    "                                                \n"  + 
    "                                                \n"  + 
    "    " ; 
}