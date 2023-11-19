$byCase = ((Get-Content .\classic_ascii_distros) -join "\n" -split "\s{8}?;;[^;][^\s]")
$byCase | % {
    Write-Output ($_ -split ('EOF'))[1]
    .Replace("\n", "`n")
    .Replace("'`n", "") >
    "$PWD/classic_ascii/" + $_.Split('"')[1]
        .Replace(" ", "_")
        .Replace("/", ".")
        .Replace("[", "")
        .Replace("]", "")
}