FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /src
COPY ["RandomGenerator.csproj", "."]
RUN dotnet restore "RandomGenerator.csproj"
COPY . .
RUN dotnet build "RandomGenerator.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "RandomGenerator.csproj" -c Release -o /app/publish

ENV ASPNETCORE_URLS=http://0.0.0.0:8080

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
WORKDIR /app/wwwroot/_framework
CMD "dotnet /app/wwwroot/_framework/RandomGenerator.dll"
