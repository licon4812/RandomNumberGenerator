# Build Stage
FROM mcr.microsoft.com/dotnet/sdk:6.0 AS build
WORKDIR /app
COPY ["RandomGenerator.csproj", "."]
RUN dotnet restore "./RandomGenerator.csproj"
COPY . .
WORKDIR "/app/."
RUN dotnet build "RandomGenerator.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "RandomGenerator.csproj" -c Release -o /app/publish /p:UseAppHost=false

# Runtime Stage
FROM nginx:alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]
