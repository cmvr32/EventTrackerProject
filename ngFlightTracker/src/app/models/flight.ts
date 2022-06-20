export class Flight {

  id: number;
  location: string | null;
  date: string | null;
  acftNumber: string | null;
  flightType: string | null;
  missionType: string | null;
  dayInHours: number | null;
  nightInHours: number | null;
  nightVisionGoggles: number | null;
  durationInHours: number | null;
  pcId: number | null;
  piId: number | null;
  ceId: number | null;
  moId: number | null;
  fiId: number | null;

  constructor(
    id: number =0,
    location: string | null = '',
    date: string | null = '',
    acftNumber: string | null = '',
    flightType: string | null = '',
    missionType: string | null = '',
    dayInHours: number | null = 0,
    nightInHours: number | null = 0,
    nightVisionGoggles: number | null = 0,
    durationInHours: number | null = 0,
    pcId: number | null = 0,
    piId: number | null = 0,
    ceId: number | null = 0,
    moId: number | null = 0,
    fiId: number | null = null
  ) {
    this.id = id;
    this.location = location;
    this.date = date;
    this.acftNumber = acftNumber;
    this.flightType = flightType;
    this.missionType = missionType;
    this.dayInHours = dayInHours;
    this.nightInHours = nightInHours;
    this.nightVisionGoggles = nightVisionGoggles;
    this.durationInHours = durationInHours;
    this.pcId = pcId;
    this.piId = piId;
    this.ceId = ceId;
    this.moId = moId;
    this.fiId = fiId;

  }

}
