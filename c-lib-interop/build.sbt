scalaVersion := "2.11.12"

// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := true

nativeLinkingOptions := Seq(
    "-L/usr/local/lib",
    "-L" + target.value
)

enablePlugins(ScalaNativePlugin)


