function Save-ToJavaEnum {
  [CmdletBinding()]
  param (
    [String]
    [ValidateScript({ Test-Path $_ -PathType Container })]
    $Directory,
    [String]
    [ValidateScript({ Test-Path $_ -PathType Leaf })]
    $JavaFile
  )

  Get-ChildItem | ForEach-Object {
    foreach ($Item in @("`t$($_.Name.ToUpper())(`"`"`"", (Get-Content $_), "`"`"`")")) {
      Add-Content $JavaFile -Value $Item
    } 
  }
}